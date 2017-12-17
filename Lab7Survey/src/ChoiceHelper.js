import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Survey from './components/Survey.js';


    const choiceHelper = {
        addChoiceToList: (choicesList, choiceToAdd) => 
        {
            var newChoicesList = [...choicesList];
            if(choiceToAdd=="") return;
            newChoicesList.push({
                id: Math.floor((Math.random()*1000)+1),
                content: choiceToAdd,
                votes: 0,
                percentage: 0
            });
            //console.log(newChoicesList);
            return newChoicesList;
        },

        modifyChoicesList: (choicesList, idToModify, votes) => {
            
            const otherChoices = choicesList.filter(a => a.id != idToModify);
            var otherChoicesVotesObject = otherChoices.reduce((a,b) =>({votes: parseInt(a.votes) + parseInt(b.votes)}));
            var votesNumber = parseInt(otherChoicesVotesObject.votes) + parseInt(votes);


            choicesList.forEach(choice => {
                
                if(choice.id == idToModify){
                    choice.votes = votes;
                }
                choice.percentage = Math.floor(choice.votes/votesNumber*100);
                if(votesNumber==0){ 
                    choice.votes = 0;
                    choice.percentage = 0;
                }
            });

            return choicesList;
        }
    }
    export {choiceHelper};

