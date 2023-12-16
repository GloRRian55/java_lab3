import exception.ObjectWithoutPlaceException;
import groups.Crowd;
import groups.Group;
import groups.Procession;
import humans.*;
import humans.states.Symptom;
import interfaces.CooperativeThink;
import places.OwnersGarden;
import places.Place;
import places.Yershalayim;
import world.World;
import world.time.states.TimeState;

public class Main {
    public static void main(String[] args) throws ObjectWithoutPlaceException, InterruptedException, CloneNotSupportedException {
        long startTime = System.currentTimeMillis();

        Matvey matvey = new Matvey();
        Yeshua yeshua = new Yeshua();
        Owner owner = new Owner();
        Procurator procurator = new Procurator();
        Legioner legioner1 = new Legioner();
        Legioner legioner2 = (Legioner) legioner1.clone();

        Crowd crowd = new Crowd();
        Procession procession = new Procession();

        OwnersGarden garden = new OwnersGarden();
        Yershalayim yershalayim = new Yershalayim();
        OwnersGarden.Shed shed = garden.new Shed();

        garden.placeAll(new Human[]{matvey, yeshua, owner, legioner1});
        yershalayim.placeAll(new Group[]{crowd, procession});
        yershalayim.placeObject(procurator);

        World world = new World(new Place[]{garden, yershalayim, shed});

        matvey.work(world.getLocation(matvey));
        yeshua.work(world.getLocation(matvey));
        matvey.support(owner);
        yeshua.support(owner);

        // TODO: 16.12.2023 сделать думание вместе | done
        CooperativeThink cooperativeThink = humans -> {
            for (Human human : humans){
                human.think("We will soon go to Yershalaim in the evening in the cold");
            }
        };
        cooperativeThink.think(new Human[] {matvey, yeshua});

        yeshua.hurry(yershalayim);
        yeshua.sayTo("I have an urgent matter in town!", matvey);
        world.time.setTime(TimeState.DAY);
        yeshua.move(world.getLocation(yeshua), yershalayim);

        world.time.setTime(TimeState.EVENING);
        // TODO: 16.12.2023 сделать симптомы объектами | done
        matvey.sick(new Symptom[]{Symptom.SHAKING, Symptom.HEAT, Symptom.CHATTER_TEETH, Symptom.THIRST});
        matvey.move(world.getLocation(matvey), shed);
        matvey.lay();
        world.time.setTime(TimeState.NIGHT);
        world.time.setTime(TimeState.MORNING);
        matvey.heal();
        matvey.think("Trouble is coming");
        matvey.sayTo("Goodbye", owner);
        matvey.move(world.getLocation(matvey), garden);
        matvey.move(world.getLocation(matvey), yershalayim);

        matvey.think("The trouble happened");
        matvey.excite();
        procurator.announce("Yeshua was sentenced to crucifixion for his statements about faith and truth.");
        crowd.moveInsidePlace(world.getLocation(crowd), "to the mountain");
        matvey.moveInsidePlace(world.getLocation(matvey), "to the mountain");
        matvey.think("It is necessary to let Yeshua know at least that I, Levi, am here with him, that I did not abandon him on the last path and that I pray that Yeshua's death befall as soon as possible.");
        procession.moveInsidePlace(world.getLocation(procession), "to the road");
        // TODO: 16.12.2023 реализовать slip | done
        matvey.think("With great dexterity and a very precise calculation, it was possible, bending over, to slip between two legionnaires, reach the cart and jump on it.");
        matvey.slip(legioner1, legioner2);
        matvey.think("Then Yeshua is saved from torment.");
        // TODO: 16.12.2023 реализвать прогноз | done
        matvey.predicts("One moment is enough to stab Yeshua in the back with a knife, shouting to him: \"Yeshua! I'm saving you and leaving with you! I, Matvey, am your faithful and only disciple!\"");
        matvey.predicts("And if God had blessed one more free moment, you could have had time to stab yourself, avoiding death on the stake.");
        matvey.predicts("I only want Yeshua, who has not done anyone the slightest harm in his life, to avoid torture.");

        System.out.println((System.currentTimeMillis() - startTime)/1000L);
    }
}
