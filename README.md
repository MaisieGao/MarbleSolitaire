**Game View**

<img width="497" alt="Screen Shot 2022-10-05 at 5 24 08 PM" src="https://user-images.githubusercontent.com/90473308/194187212-2ea26d3b-a280-48a5-b2a0-351d3eb27a6c.png">

You could go to res/project6.jar and press it to play.

<hr />
*I	created interactive and graphic games of marble solitaire following the Model View Controller (MVC) architecture using Java. 
<br/>
*I first created the Model following the rule of tictactoe, and think about what operations I need to perform such a game. Such as whose turn it is, how to make a move, whether the game is over, who win the game, and describe the current game state on the board in a string.

*I created necessary attributes and formalize these operations as methods in the tictactoe model. 

*I use Junit tests to test the model.

*The View presents the data to the user. It is the graphical user interface. I used Java's Swing library such as JFrame to create the view.

*I created the controller that is responsible for controlling the application logic and acted as the coordinator between the View and the Model.

*When user click the cell on the board, view captures cell click and send move to controller, the controller sent to the model to call the methods. The result of this action is then transferred back from the model to the controller and displays the corresponding messages in the view.
