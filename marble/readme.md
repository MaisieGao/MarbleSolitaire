I	created interactive and graphic games of marble solitaire following the Model View Controller (MVC) architecture using Java. 
<br />

*I first created the Model following the rule of tictactoe, and think about what operations I need to perform such a game. Such as whose turn it is, how to make a move, whether the game is over, who win the game, and describe the current game state on the board in a string.
<br />
I created necessary attributes and formalize these operations as methods in the tictactoe model. 
<br />
I use Junit tests to test the model.
<br />

*The View presents the data to the user. It is the graphical user interface. I used Java's Swing library such as JFrame to create the view.

*I created the controller that is responsible for controlling the application logic and acted as the coordinator between the View and the Model.
<br />
When user click the cell on the board, view captures cell click and send move to controller, the controller sent to the model to call the methods. The result of this action is then transferred back from the model to the controller and displays the corresponding messages in the view.
