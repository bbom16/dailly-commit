package com.hackday.dailycommit.Commit.service.impl;

import com.hackday.dailycommit.Commit.dao.CommitDao;
import com.hackday.dailycommit.Commit.dto.Commit;
import com.hackday.dailycommit.Commit.service.CommitService;
import com.hackday.dailycommit.User.dto.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CommitServiceImpl implements CommitService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CommitDao commitDao;

    @Override
    @Transactional
    public Commit insertCommit(List<User> users) {
        RestTemplate restTemplate = new RestTemplate();

        for(User user : users) {
            try{
                String jsonData = restTemplate.getForObject("https://api.github.com/users/" + user.getGithubId() + "/events", String.class);
                try{
                    JSONParser jsonParser = new JSONParser();
                    JSONArray jsonArray = (JSONArray) jsonParser.parse(jsonData);
                    for(int i=0; i<jsonArray.size(); i++) {
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        String eventType = (String) jsonObject.get("type");
                        /* commit 여부를 확인 */
                        if (eventType.equals("PushEvent") || eventType.equals("PullRequestEvent")) {
                            LocalDateTime commitDate = LocalDateTime.parse((String) jsonObject.get("created_at"), DateTimeFormatter.ISO_ZONED_DATE_TIME);
                            logger.debug("now : {} commitDate : {}\n", LocalDate.now(), LocalDate.from(commitDate));
                            /* 날짜가 오늘 날짜인지 확인 */
                            if (LocalDate.from(commitDate).isEqual(LocalDate.now())) {
                                JSONObject payload = (JSONObject) jsonObject.get("payload");
                                JSONArray commit = (JSONArray) payload.get("commits");
                                JSONObject lastCommit = (JSONObject) commit.get(0);

                                JSONObject repo = (JSONObject) jsonObject.get("repo");
                                Commit newCommit = new Commit();
                                newCommit.setUserId(user.getId());
                                newCommit.setRepo((String) repo.get("name"));
                                newCommit.setCommitContent((String) lastCommit.get("message"));
                                newCommit.setCommitDate(commitDate);
                                commitDao.insertCommit(newCommit);
                                logger.debug("newCommit : {}\n", newCommit);
                            }
                            break;
                        }
                    }
                    logger.debug("jsonData: {} \n", jsonArray);

                }catch (ParseException e){
                    e.printStackTrace();
                }

            }catch (HttpClientErrorException e){
                user.setEnableFlag(false); //update query 문 작성 후 실
            }

        }
        return null;
    }
}
