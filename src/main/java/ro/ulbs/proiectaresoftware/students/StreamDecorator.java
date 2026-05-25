package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;

public class StreamDecorator {
    protected String nume;
    protected String prenume;
    protected String FormatieDeStudiu;

    public  StreamDecorator(String nume, String prenume, String formatieDeStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.FormatieDeStudiu = formatieDeStudiu;
    }

    public String toCSV() {
        return nume + " " + prenume + " " + FormatieDeStudiu;
    }

    List<StreamDecorator> decorators = new ArrayList<>();
    StreamDecorator d2 = new StreamDecorator("Ggigi","Maria","C23/1");
    StreamDecorator d3 = new StreamDecorator("Popa","Mfhahsf","C23/2");
    StreamDecorator d4 = new StreamDecorator("Marsfaia","Maasffia","C23/3");

    ArrayList<StreamDecorator> listaNoua = new ArrayList<>();

}
