// AidlInterface.aidl
package AidlPackage;

// Declare any non-default types here with import statements

interface AidlInterface {
    boolean playPauseSong();
          void playSong(int position);
          int getCurrentPosition();
          List<String> getAllAudio();
          List<String> getSongDetails(int position);
}