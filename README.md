# Graph Project

## Description

This project is an Android app that allows users to create and interact with graphs. Users can add vertices and edges, and perform Depth First and Breadth First traversals, with the traversed vertices and edges highlighted in red to demonstrate the order of traversal.

## Features

- Add vertices and edges to a graph
- Perform Depth First Search (DFS)
- Perform Breadth First Search (BFS)
- Visual feedback with traversed elements highlighted in red

## Project Details

This project was developed as a school assignment and is coded entirely in Java following the MVP (Model-View-Presenter) architecture.

- **Model**: Contains all graph-related logic including edges, vertices, and traversal algorithms.
- **Presenter**: The `GraphPresenter` class manages user interactions and updates the graph.
- **View**: Consists of `DrawingView` and `MainActivity` classes for displaying the graph and user interface.

## Getting Started

### Prerequisites

- Android Studio
- Java Development Kit (JDK)

### Installation

1. Clone the repository
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

## Usage

1. Open the app on your Android device.
2. Use the spinner at the top to select an action (Add Vertex, Add Edge, DFS, BFS).
3. Interact with the graph as per your selection.

