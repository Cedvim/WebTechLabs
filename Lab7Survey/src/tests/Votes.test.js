import React from 'react';
import ReactDOM from 'react-dom';
import Choice from '../components/Choice';
import {choiceHelper} from '../ChoiceHelper'

it('updates a vote number and the percentages to the list', () => {

    const defaultChoices = [
      {id: 1, content: "Game of Thrones", votes: 0, percentage: 0},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 100}
    ];
  
    const newChoices = choiceHelper.modifyChoicesList(defaultChoices, 1, 8);
  
    const expectedChoices = [
      {id: 1, content: "Game of Thrones", votes: 8, percentage: 80},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 20}
    ];
  
    expect(newChoices).toEqual(expectedChoices);
  });
