import unittest
from checkneighbours import get_same_neighbours_ids
from checkneighbours import get_same_neighbours_ids, NegativeIndex

class TestFunctions(unittest.TestCase):
    voorbeeld_grid = [ 0, 0, 1, 0,
                      1, 1, 0, 2,
                      2, 0, 1, 3,
                      0, 1, 1, 1 ]
    
    ## een index in het midden
    def test_index_5(self):
        result = get_same_neighbours_ids(self.voorbeeld_grid, 4, 4, 5)
        self.assertEqual(result, [2,4,10])
    
    ## rechterbovenhoek
    def test_hoek(self):
        result = get_same_neighbours_ids(self.voorbeeld_grid, 4, 4, 3)
        self.assertEqual(result, [6])
    
    ## geen buren
    def test_geen_buren(self):
        result = get_same_neighbours_ids(self.voorbeeld_grid, 4, 4, 8)
        self.assertEqual(result, [])
    
    ## out of bound
    def test_out_of_bounds(self):
        with self.assertRaises(IndexError):
            get_same_neighbours_ids(self.voorbeeld_grid, 4, 4, 21)

    ## onderrand
    def test_onderrand(self):
        result = get_same_neighbours_ids(self.voorbeeld_grid, 4, 4, 13)
        self.assertEqual(result, [10, 14])
    
    ## negatieve index
    def test_negatieve_index(self):
        with self.assertRaises(NegativeIndex):
            get_same_neighbours_ids(self.voorbeeld_grid, 4, 4, -1)

if __name__ == '__main__':
    unittest.main()
