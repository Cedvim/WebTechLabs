import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import Choices from './Choices';
import Percentages from './Percentages';
import AddChoice from './AddChoice';
import {choiceHelper} from '../ChoiceHelper';
import Paper from 'material-ui/Paper';
import AppBar from 'material-ui/AppBar';
import {Card, CardActions, CardHeader, CardText} from 'material-ui/Card';
import {Table, TableBody,TableHeader,TableHeaderColumn,TableRow,TableRowColumn} from 'material-ui/Table';

// Choix par défaut
const defaultChoices = [
  {id: 1,
    content: "Game of Thrones",
    votes: 0,
    percentage: 0},
  {id: 2,
    content: "The Walking Dead",
    votes: 0,
    percentage: 0},
    {id: 3,
      content: "I don't watch any",
      votes: 0,
      percentage: 0}
];


//Composant Sondage
class Survey extends Component {

    constructor(){
      super();
      this.state = {
        choices: defaultChoices
      }
    }

    //Fonction d'affichage général (impossible de séparer en plusieurs blocs avec les éléments MUI imbriqués)
    render() {
      return (
          <Paper className="survey" zDepth={4}>
              <p></p>


              {/* Barre de titre => AppBar MUI */}
              <AppBar title="What is your favourite TV show ?" iconClassNameLeft="none" />


                {/* Résultats et pie chart => Card MUI */}
                <Card className="divCard">

                  {/* Titre */}
                  <CardHeader className="titleCard" title="Results" subtitle="See all the answers" />

                  {/* Affichage des choix et de leurs pourcentages => Composant Percentages */}
                  <CardText>
                    <Percentages choices={this.state.choices}/>
                  </CardText>

                </Card>



                {/* Votes => Card MUI */}
                <Card className="divCard">

                  {/* Titre */}
                  <CardHeader className="titleCard" title="Votes" subtitle="Make your choice" />

                  {/* Affichage des choix et du champs d'ajout */}
                  <CardText>

                    {/* Tableau contenant les choix => Table MUI */}
                    <Table>

                      {/* Entête */}
                      <TableHeader displaySelectAll={false} adjustForCheckbox={false}>
                        <TableRow>
                          <TableHeaderColumn className="column">Name</TableHeaderColumn>
                          <TableHeaderColumn  className="column">Number of votes</TableHeaderColumn>
                        </TableRow>
                      </TableHeader>

                      {/* Choix => composant Choices */}
                      <TableBody>
                        <Choices choices={this.state.choices} updateMethod={this.changePercentages}/>
                      </TableBody>
                        
                    </Table>
                    
                    {/* Champs d'ajout de choix => composant AddChoice */}
                    <AddChoice addChoice={this.addChoicesToState}/>

                  </CardText>

                </Card>
            
          </Paper>
      );
    }

    //Change les pourcentages en changeant les "choices" dans this.state
    changePercentages = (e) => {
      var id = e.target.id;
      var vote = e.target.value;

      if(vote!="" && vote>=0){  // On empêche que les votes négatifs ou nuls n'impactent les pourcentages
        this.updateState(id,vote);
      }
    }

    //Mise à jour d'un choix de this.state.choices
    updateState = (id, newVote) => {
      var newState = choiceHelper.modifyChoicesList(this.state.choices,id,newVote);
      this.setState({choices: newState});

    };

    // Ajout d'un choix dans this.state.choices
    addChoicesToState = (name) => {
      var newState = choiceHelper.addChoiceToList(this.state.choices, name);
      this.setState({choices: newState});

    };


  }

  export default Survey;
  