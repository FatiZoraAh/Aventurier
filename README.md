# Projet Aventurier 🧭

Ce projet est une simulation de déplacements d’un aventurier sur une carte ASCII, avec détection des murs et des limites de la carte.

---
## 🧱 Structure du Projet

Le projet est divisé en deux **branches**, afin de montrer l’évolution du travail :

### 🔹 `main` – Version initiale (manuelle)
- Lecture de la carte et des mouvements depuis les fichiers (`carte.txt`, `deplacements.txt`)
- Exécution de la logique avec affichage de la position finale
- Pensée comme une première étape pour valider manuellement le fonctionnement

### 🔹 `master` – Version finale (automatisée et testée)
- Ajout de tests automatisés avec **JUnit**
- Plus besoin de modifier manuellement le fichier `deplacements.txt`
- Plusieurs scénarios de test prédéfinis sont inclus
- Réorganisation du code avec une architecture plus claire et modulaire

---

## ⚙️ Fonctionnalités

- Lecture de la carte depuis un fichier texte (`carte.txt`)
- Lecture de la position de départ et de la séquence de mouvements (`deplacements.txt`)
- Détection automatique des obstacles (`#`) et des limites de la carte
- Représentation de la carte en console
- Gestion des déplacements invalides (`X`, hors carte, dans un mur)

---

## 📌 Étapes du développement

### 🔹 Partie 1 — Exécution manuelle
Dans un premier temps, la logique de simulation était testée manuellement :
- En modifiant le fichier `deplacements.txt` pour chaque scénario
- En lançant `Main.java` à chaque fois
- Et en observant la position finale imprimée en console

Cela permettait de vérifier les déplacements, mais :
- Chaque test devait être modifié à la main
- Il n’y avait aucune vérification automatisée des résultats

### 🔹 Partie 2 — Automatisation avec JUnit
Ensuite, la simulation a été encapsulée dans une méthode testable et automatisée :
- Mise en place d'une structure propre avec `src/` et `test/`
- Ajout du framework **JUnit 5** pour créer des tests unitaires
- Création de **5 tests automatisés**, dont :
  - 2 tests classiques de déplacement
  - 3 tests de cas limites (mur, sortie de carte, caractère invalide)
- Ajout d’un script de compilation simple via la CLI (sans IDE ni dépendances externes)

---

## ✅ Résultat final

### Mode manuel (branche `main`) :
- Modifier `deplacements.txt` selon les mouvements souhaités
- Exécuter `Main.java` pour obtenir la position finale

### Mode automatique (branche `master`)
- Compilation via :
  ```bash
  javac -cp "lib/junit-platform-console-standalone-1.10.0.jar" -d out src/aventurier/*.java test/aventurier/*.java
  Puis:
  java -jar lib/junit-platform-console-standalone-1.10.0.jar -cp out --scan-class-path

---

## 🙌 Remerciements

Merci pour cette opportunité.  
Ce projet m’a permis de démontrer ma capacité à construire une solution progressive, testable et maintenable.

Fatima Zahrae