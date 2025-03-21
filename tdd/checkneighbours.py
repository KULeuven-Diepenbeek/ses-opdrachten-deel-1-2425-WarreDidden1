class NegativeIndex(Exception):
    """Not a valid index"""
    pass

def get_same_neighbours_ids(grid, width, height, index_to_check):
    if index_to_check >= width * height:
        raise IndexError("Index out of bounds")
    if index_to_check < 0:
        raise NegativeIndex("Negative index")

    target_value = grid[index_to_check]
    row = index_to_check // width
    col = index_to_check % width

    directions = [(-1, -1), (-1, 0), (-1, 1),
                  (0, -1),          (0, 1),
                  (1, -1),  (1, 0), (1, 1)]
    
    same_neighbours = []
    for dr, dc in directions:
        new_row = row + dr
        new_col = col + dc
        if 0 <= new_row < height and 0 <= new_col < width:
            neighbor_idx = new_row * width + new_col
            if grid[neighbor_idx] == target_value:
                same_neighbours.append(neighbor_idx)

    return same_neighbours