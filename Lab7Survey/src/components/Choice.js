import React from 'react';
import Votes from './Votes';
import PropTypes from 'prop-types';
import {Table, TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';

//Composant stateless Choix (unique)
//Affichage d'une ligne de tableau des choix => 1e colonne nom, 2e nombre de votes 
const Choice = (props) => (

          <TableRow>

            <TableRowColumn className="column"> 
              {props.content}
            </TableRowColumn>

            <TableRowColumn className="column">
              <Votes id={props.id} name={props.content} updateMethod={props.updateMethod}/>
            </TableRowColumn>

          </TableRow>
);


//Proptypes
Choice.propTypes = {
  id: PropTypes.number.isRequired,
  content: PropTypes.string.isRequired,
  percentage: PropTypes.number.isRequired
}

  
  export default Choice;