import axios from 'axios';

//On récupére les éléments du DOM qu'on va analyser...
var calcul = document.getElementById("formula");
// Et ceux dans lesquels on va écrire
var verif = document.getElementById("verif");
var verif2 = document.getElementById("verif2");
var result = document.getElementById("result");

//Fonction d'évaluation d'une expression
function evalExpression(expression) {

        var charTab = expression.split(""); //On place tous les "caractères" dans un tableau
        var numbers = []; //tableau qui contiendra les nombres à utiliser
        var operations = []; //tableau qui contiendra les opérations à effectuer
        var index = 0; //index de parcours de la chaîne de caractères
        var OperatorOrNot = true; //variable indiquant  si on vient de remplir un opérateur ou non

        numbers[index] = "";
    
        //Répartition des nombres et opérateurs dans les tableaux
        for (var i = 0; i < charTab.length; i++) {
            
            if (isNaN(parseInt(charTab[i])) && !OperatorOrNot) { //Si l'élément visé n'est pas un nombre, et qu'on ne vient pas de remplir un opérateur
                operations[index] = charTab[i]; //Alors l'élément à remplir est un opérateur
                index++;
                numbers[index] = ""; //Et on passe à la case "nombre" suivante
                OperatorOrNot = true;
            } else { //Sinon on ajoute un chiffre à la case "nombre" actuelle
                numbers[index] += charTab[i];
                OperatorOrNot = false;
            }
        }
    
        //Calcul de l'expression
        var left = parseFloat(numbers[0]); //Element à gauche de l'opérateur

        for (var j = 0; j < operations.length; j++) {

            var right = parseFloat(numbers[j + 1]); //Element à droite de l'opérateur

            switch (operations[j]) { //Selon les opérateurs on effectue les calculs
                case "+":
                    left = left + right;
                    break;
                case "-":
                    left = left - right;
                    break;
                case "*":
                    left = left * right;
                    break;
                case "/":
                    left = left / right;
                    break;
            }
        }
    
        return left; //On retourne l'élément gauche (mis à jour) une fois les calculs faits
    }


//Gestion du clic sur le bouton "Check"
document.getElementById("checkButton").onclick = function(){

    var valCalcul = calcul.value.replace(/ /g, ""); //On enlève tous les espaces de l'expression à calculer
    var valCalculDivZero = valCalcul.replace(/[.()]/g, ""); //Pour les tests de division par zéro
 
    //Test de la formule
    axios.post("http://localhost:8081/", {formula : valCalcul}).then((response) =>{
        
        var divZero = valCalculDivZero.search("/0"); //Si la formule est bonne, on regarde s'il y a une division par zéro
        verif.innerHTML = (divZero == -1) ? "Correct formula" : "Math error"; //S'il y en a une, on affiche "Math error"

    }).catch((error) =>{
        verif.innerHTML = "Syntax error"; //Sinon on a affiche "SyntaxError"
    })

}

//Gestion du clic sur le bouton "Eval"
document.getElementById("evalButton").onclick = function(){

    var valCalcul = calcul.value.replace(/ /g, "");
    var valCalculDivZero = valCalcul.replace(/[.()]/g, ""); 

    axios.post("http://localhost:8081/", {formula : valCalcul}).then((response) =>{

        var divZero = valCalculDivZero.search("/0");
        verif2.innerHTML = (divZero == -1) ? "Correct formula" : "Math error";
        
        var resultMaybe = evalExpression(valCalcul); //On calcule l'expression
        result.innerHTML = (divZero == -1) ? resultMaybe : ""; //On affiche le résultat si l'expression est correcte

    }).catch((error) =>{
        verif2.innerHTML = "Syntax error"
    })
}

document.getElementById("formula").onclick = function(){ //On vide les cadres au clic sur le formulaire
    result.innerHTML = "";
    verif.innerHTML = "";
    verif2.innerHTML = "";
}


