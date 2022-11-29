package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour ! Je souhaite rencontrer des gens pour jouer à des jeux de cartes et discuter de tout et de rien." 

),
            new Neighbour(2, "Jack", "https://i.pravatar.cc/150?u=a042581f4e29026704e", "Grenoble : 20km",
                    "+33 6 86 57 90 14",  "Bonjour ! Je souhaiterais faire de la marche nordique. Pas initié, je recherche une ou plusieurs personnes susceptibles de m'accompagner ! J'aime les jeux de cartes tels la belote et le tarot.." 

),
            new Neighbour(3, "Chloé", "https://i.pravatar.cc/150?u=a042581f4e29026704f", "Labastide-d'Armagnac ; 7km",
                    "+33 6 86 57 90 14",  "Bonjour ! Je suis à la recherche de personnes pour mon club de lecture. Fanas de SF, n'hésitez plus et rejoignez-nous !" 

),
            new Neighbour(4, "Vincent", "https://i.pravatar.cc/150?u=a042581f4e29026704a", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 56 26 26 26",  "Bonjour ! J'adore les films d'arts martiaux et je cherche des gens pour m'accompagner !"

),
            new Neighbour(5, "Elodie", "https://i.pravatar.cc/150?u=a042581f4e29026704b", "Mugron ; 6km",
                    "+33 6 58 58 58 58",  "Bonjour ! Je suis à la recherche de personnes qui souhaiteraient voyager !"

),
            new Neighbour(6, "Sylvain", "https://i.pravatar.cc/150?u=a042581f4e29026704c", "Saint-Pierre-du-Port ; 15km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.." 

),
            new Neighbour(7, "Laetitia", "https://i.pravatar.cc/150?u=a042581f4e29026703d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.." 

),
            new Neighbour(8, "Dan", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Panjas ; 7km",
                    "+33 6 14 14 14 14",  "Bonjour ! Avis aux amateurs de mots-croisés, j'organise des goûters cruciverbistes, n'hésitez pas à me contacter !"

),
            new Neighbour(9, "Josephine", "https://i.pravatar.cc/150?u=a042581f4e29026704d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 90 90 90 90",  "Bonjour ! Vous avez un souci avec votre ordinateur ? Passionnée d'informatique, je me ferais une joie de vous aider, envoyez-moi un message !"

),
            new Neighbour(10, "Emma", "https://i.pravatar.cc/150?u=a042581f4e29026706d", "Roquefort ; 12km",
                    "+33 6 12 12 12 12",  "Bonjour ! J'aimerais apprendre la salsa... si vous aimeriez vous aussi vous lancer, n'attendez plus et contactez-moi ! C'est tellement plus motivant !"

),
            new Neighbour(11, "Patrick", "https://i.pravatar.cc/150?u=a042581f4e29026702d", "Brocas ; 15km",
                    "+33 6 57 57 57 57",  "Bonjour ! J'adore aller nager, mais c'est un peu démotivant d'y aller tout seul... si vous voulez m'accompagner, merci de me contacter."

),
            new Neighbour(12, "Ludovic", "https://i.pravatar.cc/150?u=a042581f3e39026702d", "Saint-Pierre-du-Mont ; 5km",
                    "+33 6 86 57 90 14",  "Bonjour ! Je recherche des amateurs de brocantes : on pourrait aller chiner de belles trouvailles et boire un café après, c'est plus sympa en groupe, non ?"

)
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }
}
