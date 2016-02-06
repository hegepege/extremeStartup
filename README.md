https://blog.codecentric.de/en/2015/06/extreme-startup-at-codecentric

What to do:

1. Gamehost starts the server

2. The participants register themselves by providing a URL (usually their local IP address).

3. The game server then starts to send HTTP requests containing questions to the registered URLs. 
   Players have to implement an application that is capable of answering the questions send by the game server.
   
4. Every time no response or a wrong result is returned, players get minus points. Correct answers are rewarded by plus points. 
   This is all visualized on a leader board, which we displayed via a beamer at the front of the conference room we were sitting in.
   
   
   
So we need a simple client that posts our URL to the game server.
Then a server that can receive requests and answer to the game server.
