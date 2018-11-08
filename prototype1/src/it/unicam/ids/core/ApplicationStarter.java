package it.unicam.ids.core;

public class ApplicationStarter {
    public static void main(String[] argv) {
        Citizen Pippo = new Citizen("Pippo", "Bello", "10/09/2018", "pippo@mailinator.com");
        Citizen Pluto = new Citizen("Pluto", "Brutto", "10/08/2018", "pluto@mailinator.com");
        Citizen Caio = new Citizen("Caio", "Semp", "12/02/2017", "caiosemp@mailinator.com");
        Report piprep = new Report(Pippo, "wtf is happening", "Problem");
        piprep.addComment(Pippo, "bella");
        piprep.addComment(Pippo, "second");
        piprep.addComment(Pluto, "nooo");
        piprep.addComment(Caio, "Male, molto male");
        piprep.showReportContent();
    }
}
