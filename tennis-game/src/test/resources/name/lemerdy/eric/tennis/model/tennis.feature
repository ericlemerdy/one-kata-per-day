# language: fr
Fonctionnalité: Choix du côté et service
  
  Le choix du côté et le droit d’être serveur ou relanceur dans le premier jeu seront décidés par tirage
  au sort avant le début de l’échauffement. Le joueur/l’équipe qui gagne le tirage au sort peut choisir :
  - de servir ou de recevoir dans le premier jeu de la partie, dans ce cas, l’adversaire choisira son
  côté de terrain pour le premier jeu de la partie ; ou
  - son côté de terrain pour le premier jeu de la partie, auquel cas l’adversaire choisira de servir ou
  de recevoir pour le premier jeu de la partie ; ou
  - d’obliger son/ses adversaire(s) à faire un des choix ci-dessus

  Scénario: Le joueur gagnant au tirage au sort choisit de servir ou recevoir
    Étant donné un joueur "Agassi"
    Et un joueur "Federer"
    Et "Agassi" gagne le tirage au sort
    Lorsque "Agassi" choisit de servir ou recevoir dans le premier jeu de la partie
    Alors "Federer" doit choisir le côté de terrain dans le premier jeu de la partie

  Scénario: Le joueur gagnant au tirage au sort choisit son coté de terrain
    Étant donné un joueur "Agassi"
    Et un joueur "Federer"
    Et "Agassi" gagne le tirage au sort
    Lorsque "Agassi" choisit le côté de terrain dans le premier jeu de la partie
    Alors "Federer" doit choisir de servir ou recevoir dans le premier jeu de la partie

  Scénario: Le joueur gagnant au tirage au sort oblige son adversaire à faire un choix
    Étant donné un joueur "Agassi"
    Et un joueur "Federer"
    Et "Agassi" gagne le tirage au sort
    Lorsque "Agassi" choisit de donner le choix à son adversaire
    Alors "Federer" doit faire un choix

  Scénario: Le joueur choisit de servir
    Étant donné un joueur "Agassi"
    Et un joueur "Federer"
    Lorsque "Agassi" choisit de "servir" dans le premier jeu de la partie
    Alors "Federer" doit "recevoir" dans le premier jeu de la partie

  Scénario: Le joueur choisit de recevoir
    Étant donné un joueur "Agassi"
    Et un joueur "Federer"
    Lorsque "Agassi" choisit de "recevoir" dans le premier jeu de la partie
    Alors "Federer" doit "servir" dans le premier jeu de la partie

  Scénario: Le joueur choisit le côté de terrain à gauche de l'arbitre
    Étant donné un joueur "Agassi"
    Et un joueur "Federer"
    Lorsque "Agassi" choisit le côté de terrain à "gauche" de l'arbitre dans le premier jeu de la partie
    Alors "Federer" doit jouer sur le côté de terrain à "droite" de l'arbitre dans le premier jeu de la partie
