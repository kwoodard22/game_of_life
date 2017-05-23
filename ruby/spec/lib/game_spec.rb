require 'spec_helper'
require 'game'

describe Game do
  it 'exists' do
  	board = Board.new(5, 2)

  	expect(Game.new(board))
  end
end
