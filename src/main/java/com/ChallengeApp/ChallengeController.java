package com.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge> >getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge) {
        boolean ischallengeAdded = challengeService.addChallenge(challenge);
        if (ischallengeAdded) {
            return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK) ;
        } else {
            return new ResponseEntity<>("Challenge cannot be added",HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month) {
        Challenge challenge= challengeService.getChallengeByMonth(month);
        if (challenge != null){
            return  new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id ,@RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated=challengeService.updateChallenge(id,updatedChallenge);
        if(isChallengeUpdated){
           return new ResponseEntity<>("Challenge Updated successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Challenge not Updated successfully",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
       boolean ischallengeDeleted= challengeService.deleteChallenge(id);
       if(ischallengeDeleted){
           return new ResponseEntity<>("challenge Deleted Successfully",HttpStatus.OK);
       }
       else
           return new ResponseEntity<>("Challenge Cannot be Deleted",HttpStatus.NOT_FOUND);
    }
}