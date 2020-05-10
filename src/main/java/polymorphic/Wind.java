package polymorphic;

/**
 * @author momoubin
 * @date 2020/5/10
 */
public class Wind extends Instrument{
    public void play(Note note){
        System.out.println("Wind.play " + note);
    }
}

class Instrument{
    public void play(Note note){
        System.out.println(note);
    }
}