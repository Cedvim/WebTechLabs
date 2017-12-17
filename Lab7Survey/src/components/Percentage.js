import React from 'react';
import PropTypes from 'prop-types';
import Paper from 'material-ui/Paper';

// Affichage des blocks de pourcentage => on les place dans un bloc ombré (Paper en Material-UI)
const Percentage = (props) => (
        <Paper zDepth={1} id={"percent" + props.id}  className="percentages">
          {props.content} :  {props.percentage}%
        </Paper>
);
export default Percentage;

//Proptypes
Percentage.propTypes = {
  id: PropTypes.number.isRequired,
  content: PropTypes.string.isRequired,
  percentage: PropTypes.number.isRequired
}
  