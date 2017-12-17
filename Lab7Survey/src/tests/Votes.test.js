import React from 'react';
import ReactDOM from 'react-dom';
import Choice from '../components/Choice';
import {choiceHelper} from '../ChoiceHelper'

it('updates a vote number and the percentages in the list', () => {
   //Vérifie la modification d'un vote, et la mise à jour des pourcentages

   //Liste de départ
    const defaultChoices = [
      {id: 1, content: "Game of Thrones", votes: 0, percentage: 0},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 100}
    ];
  
    //Modification du premier choix
    const newChoices = choiceHelper.modifyChoicesList(defaultChoices, 1, 8);
  
    //Liste attendue
    const expectedChoices = [
      {id: 1, content: "Game of Thrones", votes: 8, percentage: 80},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 20}
    ];
  
    //Vérification
    expect(newChoices).toEqual(expectedChoices);
  });


  it('set to 0 the only votes does not return an NaN or an Infinity', () => {
     //Vérifie si la mise à jour de tous les votes à 0 n'affiche pas des pourcentages faux (Infinity/NaN)

     //Liste de départ
    const defaultChoices = [
      {id: 1, content: "Game of Thrones", votes: 0, percentage: 0},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 100}
    ];
  
    //Mise à zéro des votes
    const newChoices = choiceHelper.modifyChoicesList(defaultChoices, 2, 0);
  
    //Liste attendue
    const expectedChoices = [
      {id: 1, content: "Game of Thrones", votes: 0, percentage: 0},
      {id: 2, content: "The Walking Dead", votes: 0, percentage: 0}
    ];
  
    //Vérification
    expect(newChoices).toEqual(expectedChoices);
  });
