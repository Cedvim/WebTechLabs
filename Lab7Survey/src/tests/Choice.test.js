import React from 'react';
import ReactDOM from 'react-dom';
import Choice from '../components/Choice';
import {choiceHelper} from '../ChoiceHelper'

  it('adds a choice to the list', () => {
    //Vérifie si un choix est bien ajouté à la liste
  
    //Liste de départ
    const initialChoices = [
      {id: 1, content: "Game of Thrones", votes: 0, percentage: 0},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 100}
    ];
  
    //Ajout du choix avec le helper
    const newChoices = choiceHelper.addChoiceToList(initialChoices, "Breaking Bad");
  
    //Liste attendue
    const expectedChoices = [
      ...initialChoices,
      newChoices[2]
    ];
  
    //Vérification
    expect(newChoices).toEqual(expectedChoices);
  });

  it('does not change the initial list to add a choice using the helper', () => {
    //Vérifie l'ajout d'un choix à la liste ne modifie pas la liste initiale
  
    //Liste de départ
    const initialChoices = [
      {id: 1, content: "Game of Thrones", votes: 0, percentage: 0},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 100}
    ];

    //Copie de cette liste
    const expectedChoices = [...initialChoices ];
  
    //Ajout du choix avec le helper
    choiceHelper.addChoiceToList(initialChoices, "Breaking Bad");
  
    //Vérification
    expect(initialChoices).toEqual(expectedChoices);
  });
  