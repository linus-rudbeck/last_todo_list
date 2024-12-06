# Last To-Do List

## Overview

The **Last To-Do List** project is a command-line application designed to manage tasks effectively. Users can create regular and priority tasks, mark tasks as completed, and view all tasks. The application demonstrates file handling, inheritance, and abstraction in Java, and introduces concepts of task prioritization and persistence.

The program saves tasks to a file, ensuring that data is retained between sessions, making it a practical example of file I/O operations.

## Features

1. **Task Management:**
    - Add regular tasks with a name.
    - Add priority tasks with a name and priority level.
    - Mark tasks as completed.
    - View all tasks, categorized by type and completion status.

2. **Task Persistence:**
    - Tasks are saved to and loaded from a text file (`tasks.txt`), ensuring data is retained.

3. **Command-Line Interface:**
    - Easy-to-use menu system for managing tasks interactively.

## Project Structure

- **Main Application:**
    - `Main.java`: The entry point for the program. Manages user interaction and menu logic.
    - `TaskManager.java`: Handles core task management functionalities such as adding, displaying, marking, saving, and loading tasks.

- **Task Models:**
    - `Task.java`: An abstract base class defining common attributes and methods for all tasks.
    - `RegularTask.java`: Represents a standard task.
    - `PriorityTask.java`: Extends `Task` to include a priority level.

- **File Operations:**
    - Task data is stored in a file with the format:
        - `REGULAR - <Task Name> - <Completion Status>`
        - `PRIORITY - <Task Name> - <Priority> - <Completion Status>`

This project is a practical demonstration of core Java principles, including object-oriented programming, file handling, and interactive console applications. It is ideal for learning task management implementation and working with data persistence.
