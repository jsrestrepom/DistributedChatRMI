DistributedChatRMI
==================

Diseño e Implementación de un chat distribuido utilizando RMI.Reto2 de la materia ST0263-2013-1 de la universidad EAFIT.



How to running

In order to run the challenge you need to follow the nexts spets:
  1.  Download the source from the web site http://sistemas.eafit.edu.co/~jrestr76/reto2 or download it directly from
      this repositorie.
  2.  Unzip the content.
  3.  Open the terminal and move the cursor to the directory you unzip the content.
  4.  Now compile the java files starting with the interface IChatMessage, use the command 
        javac src/contract/IChatMessage.java
  5.  Then compile the server and client packages with the commands:
        javac src/server/ChatMessage.java src/server/ChatServer.java
        javac src/client/TypingThread.java src/client/pollingThread.java src/client/ChatClient.java
  6.  At this point you can start the ChatServer executing the command
        java src/server/ChatServer
  7.  Finally execute the number of clients you want with
        java src/client/ChatClient
