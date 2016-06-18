package com.rong.flora.animal;

/**
 * Created by lafengnan on 16/6/15.
 */
public abstract class  Animal {
    private String mouse;
    private String eyes;
    private  String ears;
    private String legs;

    public Animal(String ears, String eyes, String legs, String mouse) {
        this.ears = ears;
        this.eyes = eyes;
        this.legs = legs;
        this.mouse = mouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (mouse != null ? !mouse.equals(animal.mouse) : animal.mouse != null) return false;
        if (eyes != null ? !eyes.equals(animal.eyes) : animal.eyes != null) return false;
        if (ears != null ? !ears.equals(animal.ears) : animal.ears != null) return false;
        return legs != null ? legs.equals(animal.legs) : animal.legs == null;

    }

    @Override
    public int hashCode() {
        int result = mouse != null ? mouse.hashCode() : 0;
        result = 31 * result + (eyes != null ? eyes.hashCode() : 0);
        result = 31 * result + (ears != null ? ears.hashCode() : 0);
        result = 31 * result + (legs != null ? legs.hashCode() : 0);
        return result;
    }

    public String getEars() {
        return ears;
    }

    public void setEars(String ears) {
        this.ears = ears;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public void eat(String food){
        mouse = food;
        System.out.println("Animal: " + mouse);

    }

    public void listen(String music){
        ears = music;
        System.out.println("Animal: " + ears);
    }

    public void watch(String movie){
        eyes = movie;
        System.out.println("Animal " + eyes);

    }

    public void run(String go){
        legs = go;
        System.out.println("Animal: " + legs);
    }

}
