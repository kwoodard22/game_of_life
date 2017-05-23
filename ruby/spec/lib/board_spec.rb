require 'spec_helper'
require 'board'

describe Board do
  it 'exists' do
    expect(Board.new(5, 2))
  end

  describe 'board size' do
      it 'creates a specific sized board' do
        expect(Board.new(5, 2).size).to eq 5
      end

      # it 'errors if board size is less than 4' do
      #     expect(Board.new(3, 2)).to raise 'Size Error: Board size must be 4 or greater'
      # end

      it 'builds an empty board' do
        expect(Board.new(5, 2).board).to eq board
      end
  end

  describe 'starting cells' do
      it 'generates cell starting positions' do
        positions = Board.new(5, 2).live_cell_locations
        expect(positions.class).to be Array
        expect(positions.length).to be 2
        expect(positions.first.length).to be 2
      end

      it 'updates board' do
        board = Board.new(5, 2)
        board.update_board
        
        expect(board.board).to 
      end
  end
end

def board
    [
      [0,0,0,0,0],
      [0,0,0,0,0],
      [0,0,0,0,0],
      [0,0,0,0,0],
      [0,0,0,0,0]
    ]
end
