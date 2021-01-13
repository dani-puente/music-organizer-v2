import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Muestra todos los archivos en la coleccion
     */
    public void listAllFiles(){
        int cont = 0;
        while(cont < files.size()){
            String filename = files.get(cont);
            System.out.println((cont + 1) + ": " + filename);
            cont++;
        }
    }

    /**
     * Muestra los archivos que contengan el parametro
     */
    public void listMatching(String busqueda){
        boolean siEsta = false;
        for(String filename : files){
            if(filename.contains(busqueda)){
                siEsta = true;
                System.out.println(filename);
            }

        }
        if(siEsta == false){
            System.out.println("No hay un archivo con este nombre");
        }
    }

    /**
     * reproduzca los primeros segundos de todas las canciones de un determinado artista
     */
    public void playSamplesArtist(String artista){
        for(String cancion : files){
            if(cancion.contains(artista)){
                player.playSample(cancion);
            }
        }
    }

    /**
     * Borra todas las canciones del organizador que contengan el texto indicado usando un bucle for-each.
     */
    public void deleteSongsWithText(String textoABorrar){

    }

    /**
     * Localiza el índice del primer archivo que se corresponde con
     * la cadena de búsqueda indicada .
     * @param searchString La cadena que hay que buscar.
     * @return El índice de la primera aparición o -1 si
     * no se encuentra ninguna correspondencia
     */
    public int findFirst(String searchString){
        String textoABuscar = searchString;
        int index = 0;
        int cont =0;
        while(cont == 0 && index < files.size()){
            String filename = files.get(index);
            if(filename.contains(textoABuscar)){
                cont++;
            } else{
                index++;
            }
        }
        if(cont == 0){
            index = -1;
        }
        return index;
    }
}