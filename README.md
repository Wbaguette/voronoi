# voronoi
## Voronoi Diagram 
Link : https://en.wikipedia.org/wiki/Voronoi_diagram.
Small project using base Java graphic library to display a 2D voronoi diagram. 
This is the 'naive' approach, i.e. iterating through every individual pixel and for each pixel iterating through all seeds.

 Overall Steps:
 1) 'n' seeds have their points randomly generated (x,y) and have a randomly generated color assigned to them
 2) For each pixel/point in the window panel, the closest seed is found
 3) Point is 'painted' with the color of closest seed, resulting in a cool looking diagram                                                                                                                                                      
