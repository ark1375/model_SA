# ModelSA

Welcome to Model-SA.   

This project is a simple solution for **K-Modem Illumination Problem**.
We used Monte Carlo technique alongside with Genetics Algorithm for solving the problem.
The code itself is written in __Java__ (Requirements are listed below) and it is heavily dependent on the JTS geometry library.   

This repository contains   
- The Projects Source   
- Documentation and Screenshots   
- Test Cases   
- A Randomly generated dataset of simple geometries   

**Warning!**   
The following readme file **Dose Not** contain detailed information about the problem.   
For further information on technical details of the problem, experiments and theire results, check out [Technical Details](TechincalDetails.md)

## Table of Contents
* [Problem Description](#problem-description)
* [Requirements](#requirements)
* [Installation](#installation) 
* [A tour of the code](#a_tour_of_the_code) 
* [How to use?](#how_to_use?)
* [Credits](#credits)  

## Problem Description
### Original K-Modem Description
For the original description of K-Modem problem, check out the [Technical Details](TechincalDetails.md/#problem_description).

### One Variation of K-Modem Problem
_**Note**: This is a subset of the original K-Modem illumination problem and it is the actual problem that the code is written for. With little adjustments (check [Technical Details](TechincalDetails.md/#problem_description)) the code can solve the original problem as well. The solution code for the original K-Modem Illumination problem will be included in future updates._  
  

Let **_P_** be a simple polygon consist of an outter shell (the outter walls) and zero or more holes (check the screenshot bellow). Given the number of k-modems available _q_, and the penetration rate _k_, what are the best cordinates to put the k-modems on, such that the maximum area of the polygon is covered.   
Another custom variation of the problem comes from the asumption that the k-modems can have signal confliction. If any point is covered by more than one k-modem, signal confliction happen and the point is not covered anymore.
![sc1](/docs/screenshots/sc1.jpg)

### Practical Usage
The main practical usage of the problem comes from finding the optimal positions in a given map for the maximum coverage of a set of wirless modems with a given signal strength (eg. Maximum WiFi coverage inside a given building).
Using the available code alongside with JTS Testbuilder, you can create your own maps and find the optimal postion for your modems inside the map.


## Requirements

## Installation

## A Tour of the Code

## How to use?
Future updates may include support for common CAD file formats like .DXF or .DWG.
## Credits

## Sources