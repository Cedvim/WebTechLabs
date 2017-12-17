import React from 'react';
import ReactDOM from 'react-dom';
import Choice from '../components/Choice';
import {choiceHelper} from '../ChoiceHelper'

  
  it('add a choice to the list', () => {
  
    const initialChoices = [
      {id: 1, content: "Game of Thrones", votes: 0, percentage: 0},
      {id: 2, content: "The Walking Dead", votes: 2, percentage: 100}
    ];
  
    const newChoices = choiceHelper.addChoiceToList(initialChoices, "Breaking Bad");
  
    const expectedChoices = [
      ...initialChoices,
      newChoices[2]
    ];
  
    expect(newChoices).toEqual(expectedChoices);
  });
  