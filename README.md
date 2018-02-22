# Postfix
An implementation of a postfix calculator in Java.

# Design
The design of the postfix calculator starts with the choice of data structure. A circular doubly-linked list is created in the MyLinkedList class, and a subset of the standard functionalities of a Java LinkedList are implemented using a Node inner class. 

Then a stack is implemented in the MyStack class using the aforementioned MyLinkedList. Again, the standard stack functionalities are implemented, tightly dependent on the MyLinkedList methods.

Finally, the PostFixSolver, containing a main() method, addresses the problem of solving postfix expressions with a simple algorithm containing a series of if statements. After parsing the postfix expression from the user, it then organizes the contents into one of two categories: a number or an operator. If the character is a number, then it simply pushes it to the stack. If it is an operator, it pops the last two numbers, performs the indicated operation, and pushes the result back to the stack. After the expression is run through, it returns the answer as a double. Invalid expressions are returned as an exception and the main() will then catch them and prompt the user to try again.

# Testing
The MyLinkedList class is white box tested for 100 percent statement coverage.
The MyStack class is black box tested - the test plan for which is contained in the testplan.txt file.
