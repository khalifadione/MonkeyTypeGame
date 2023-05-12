package fr.uparis.informatique.cpoo5.richtextdemo;

public  abstract class Typedonnee<T> {
    protected T type;
    public Typedonnee(T type){
        this.type=type;
    }
    public T getType(){
        return this.type;
    }

    public void setType(T type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ceci est un "+getType();
    }
}
