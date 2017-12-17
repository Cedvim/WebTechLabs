import React, { Component } from 'react';
import Percentage from './Percentage';
import PieChart from "react-svg-piechart";

//Composant Pourcentages
class Percentages extends Component {

  // Affichage des ratios par choix
  displayPercentages(){
    return this.props.choices.map(
      t =>  <Percentage  key={t.id} {...t} />
    ); 
  }

  //Affichage du diagramme circulaire
  displayPieChart(){
    const dataChoices =[...this.props.choices]; //Copie du tableau
      const colors=["#22594e","#2f7d6d","#3da18d","#69c2b0","#a1d9ce"]; //Tableau de couleurs pour une génération aléatoire

      //Création d'un nouveau tableau adapté à la création de "pie chart" => title, value, color
      const newChoices= dataChoices.map(
        t => ({
          id:t.id,
          title:t.content,
          value: parseInt(t.votes),
          color: colors[Math.floor(Math.random() * colors.length)]
  
        })
      );
      //Affichage
      return ( 
          <div className="pieChart">
            <PieChart className="chart" data={newChoices} expandOnHover />
          </div>);
  }

  // Fonction d'affichage général
  render() {
      //Affichage
      return ( 
        <div id="">
          {this.displayPieChart()} {/* Appel à la fonction d'affichage du diagramme circulaire */}
          {this.displayPercentages()} {/* Appel à la fonction d'affichage des pourcentages */}
        </div>
      ); 
    }
}

export default Percentages;
  