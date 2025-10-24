package com.ChallengeApp;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    private final List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 2L;

    public ChallengeService() {
        Challenge challenge1 = new Challenge(1L, "Jan", "Learn something");
        challenges.add(challenge1);
    }

    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        return false;
    }

    public Challenge getChallengeByMonth(String month){
        for (Challenge challenge : challenges){
            if(challenge.getMonths().equalsIgnoreCase(month)){
                return challenge;
            }

        }
        return null;
    }
    public boolean updateChallenge(Long id,Challenge updatedChallenge){
        for (Challenge challenge : challenges){
            if(challenge.getId().equals(id)){
                challenge.setMonths(updatedChallenge.getMonths());
                challenge.setDesc(updatedChallenge.getDesc());
                return true;
            }

        }
        return false;

    }
    public boolean deleteChallenge(Long id){
        return challenges.removeIf(challenge ->challenge.getId().equals(id));
    }
}
