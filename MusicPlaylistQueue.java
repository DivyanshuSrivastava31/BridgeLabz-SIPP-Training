import java.util.LinkedList;
import java.util.Scanner;

// Base class demonstrating Polymorphism
class MediaPlayer {
    public void play(String media) {
        System.out.println("Playing: " + media);
    }
}

// MusicPlayer extending MediaPlayer
class MusicPlayer extends MediaPlayer {
    private LinkedList<String> playlist; // Encapsulation

    public MusicPlayer() {
        playlist = new LinkedList<>();
    }

    // Abstraction
    public void addSong(String song) {
        playlist.addLast(song); // Add to end
        System.out.println(song + " added to playlist.");
    }

    public void addSongToStart(String song) {
        playlist.addFirst(song); // Optional: add to beginning
        System.out.println(song + " added to the start of playlist.");
    }

    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println(song + " removed from playlist.");
        } else {
            System.out.println(song + " not found in playlist.");
        }
    }

    public void playNext() {
        if (!playlist.isEmpty()) {
            String nextSong = playlist.removeFirst();
            play(nextSong); // Using MediaPlayer method (Polymorphism)
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    public void showPlaylist() {
        System.out.println("Current Playlist: " + playlist);
    }
}

// Main driver class
public class MusicPlaylistQueue {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Song\n2. Add Song to Start\n3. Remove Song\n4. Play Next\n5. Show Playlist\n6. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    player.addSong(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter song name: ");
                    player.addSongToStart(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter song name to remove: ");
                    player.removeSong(sc.nextLine());
                    break;
                case 4:
                    player.playNext();
                    break;
                case 5:
                    player.showPlaylist();
                    break;
                case 6:
                    System.out.println("Exiting Player.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
