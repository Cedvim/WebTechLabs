import React from 'react';

    //Constante choiceHelper contenant les méthodes principales utilisée pour modifier les listes de choix
    const choiceHelper = {

        //Ajout d'un choix à la liste
        addChoiceToList: (choicesList, choiceToAdd) => 
        {
            const newChoicesList = [...choicesList]; //Copie du tableau
            if(choiceToAdd=="") return; //Si le choix est vide on ne continue pas

            //Ajout du nouveau choix à la copie de la liste
            newChoicesList.push({
                id: Math.floor((Math.random()*1000)+1),
                content: choiceToAdd,
                votes: 0,
                percentage: 0
            });
            return newChoicesList; //Retourne la liste
        },

        //Modification des votes d'un choix, et mise à jour de la liste
        modifyChoicesList: (choicesList, idToModify, votes) => {
            
            //Filtrage des choix non modifiés dans un tableau
            const otherChoices = choicesList.filter(a => a.id != idToModify);
            //Compte des votes de ces choix
            const otherChoicesVotesObject = otherChoices.reduce((a,b) =>({votes: parseInt(a.votes) + parseInt(b.votes)}));
            //Ajout des nouveaux votes aux votes existants
            const votesNumber = parseInt(otherChoicesVotesObject.votes) + parseInt(votes);

            //Modification de la liste
            choicesList.forEach(choice => {
                
                if(choice.id == idToModify){
                    choice.votes = votes; //Modifications des votes du choix modifié
                }
                //Modification de tous les pourcentages
                choice.percentage = Math.floor(choice.votes/votesNumber*100);
                //Si le nombre de votes total est égal à 0, on fixe tous les votes et pourcentages à 0
                if(votesNumber==0){ 
                    choice.votes = 0;
                    choice.percentage = 0;
                }
                //Ainsi on évite les erreur d'Infini et NaN
            });

            return choicesList;
        }
    }
    export {choiceHelper};

