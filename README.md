# Algorithms-and-Data-Structures
## Coursework Implementations with **Formal Correctness Proofs and Complexity Analysis**

This repository contains selected implementations of fundamental algorithms and data structures, developed as part of my undergraduate coursework in **Data Structures and Algorithms**, **Discrete Mathematics**, and **Theory of Computation**.

The purpose of this repository is to demonstrate algorithmic reasoning, including:
- **Formal correctness arguments** (invariants, termination, edge cases)
- Data structure design choices
- Asymptotic time/space complexity **with mathematical justification**
- Trade-offs between alternative approaches

All implementations are written from scratch, without relying on built-in algorithmic libraries, to emphasize core principles.


## 🔢 Sorting and Searching

### **QuickSort**
- In-place divide-and-conquer sorting algorithm
- **Average time**: O(n log n)
- **Worst-case time**: O(n²) 
- **Space**: O(log n) (recursion stack)

### **Binary Search**
- Iterative implementation on sorted arrays
- **Time**: O(log n)

### **Linear Search**
- Baseline sequential search
- **Time**: O(n)

## 🧱 Core Data Structures

### **Stack**
- Array-based implementation
- Applications: Postfix expression evaluation, String reversal

### **Singly & Doubly Linked Lists**
- Insert, delete, traverse operations
- Reverse traversal for doubly linked list

### **Hash Table**
- Linear probing for collision resolution
- Demonstrates hashing, probing sequences, load limitations

### **Binary Search Tree (BST)**
- Insert, search, delete operations
- In-order traversal
- Analysis of balanced vs unbalanced cases

## 🌐 Graph Algorithms (**MPC-Relevant**)

**Graph Representation**: Adjacency matrix

### **Depth-First Search (DFS)**
- Path discovery between vertices
- **Time**: O(V²) (adjacency matrix)
- Sequential foundation for parallel graph processing

### **Union-Find**
- Core primitive for distributed MST, connectivity
- Demonstrates cycle detection and union operations

### **Maximum Spanning Tree**
- Union-Find–based greedy approach
- Demonstrates round-complexity thinking

## ⚙️ Greedy Algorithms

### **Job Sequencing with Deadlines**
- Profit-based greedy scheduling
- Maximizes total profit under deadline constraints
- Illustrates greedy choice property

## 🧩 NP-Complete Problems (Exposure)

### **Subset Sum**
- Recursive backtracking solution
- **Time**: O(2^n)
- Demonstrates exponential-time behavior
- Used to understand problem hardness and computational limits

## 🔤 Expression Parsing

### **Postfix Expression Evaluation**
- Stack-based parsing
- Handles multi-digit operands and error cases

### **String Reversal**
- Stack-based character reversal

## 🧠 Design Philosophy

1. **Correctness over optimization** - Implementations reflect algorithmic logic clearly
2. **Explicit complexity analysis** - Time and space complexity stated and reasoned about
3. **Educational clarity** - Code written for understanding, not brevity

## 🛠️ Language and Tools

- **Language**: Java
- **Core Concepts**: Algorithms, Data Structures, Graph Traversal, Greedy Methods, Complexity Analysis
- **Tools**: Git, CLI-based testing

## 🎓 Academic Context

These implementations were developed as part of my undergraduate training in:
- **Data Structures and Algorithms**
- **Discrete Mathematics** 
- **Theory of Computation**

They form the foundation for my interest in algorithm design, graph algorithms, and theoretical models of computation.

## 🎓 **Research Readiness for Aalto ASI**

These implementations demonstrate my preparation for **Project 4209 (MPC Graphs)** through:
- Graph algorithm implementations + complexity analysis
- NP-completeness exposure (Subset Sum reductions)
- Formal reasoning about correctness and trade-offs
- Foundation for parallel model extensions (MPC, LCA)

## ℹ️ Notes

This repository represents **coursework-level algorithmic foundations**, not research contributions. Its purpose is to demonstrate readiness for research-oriented training in algorithms and theoretical computer science.
