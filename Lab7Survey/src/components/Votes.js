import React from 'react';
import PropTypes from 'prop-types';
import TextField from 'material-ui/TextField';

//Affichage d'un vote => un champs text "number" (TextField MUI)
const Votes = (props) => (
    <div className="voteField"> 
         <TextField
            id={props.id.toString()}
            min="0" 
            defaultValue="0"
            onChange={props.updateMethod}
            type="number"
            className="votes"
          />
      </div>
);
//On a la méthode "props.updateMethod" activée au "onChange"
// => elle est passée aux composants successifs depuis le composant Survey et met à jour les pourcentages et votes


//Proptypes
Votes.propTypes = {
  id: PropTypes.number.isRequired,
  text: PropTypes.string,
  name: PropTypes.string.isRequired
}

  
  export default Votes;