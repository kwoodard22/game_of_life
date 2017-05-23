class Board
	attr_reader :size, :cell_count, :board, :cells
	
	LIVE_CELL = 1

	# Rules:
	
	# Create board with size & live cells
	# Add live cells to board
	# Update board according to rules

	# raise "Size Error: Board size must be 4 or greater" unless size > 3
	def initialize(size, cell_count)
		@size = size
		@cell_count = cell_count
		@board = build_board
		@cells = generate_starting_live_cells
	end

	def cycle
		cells.each do |cell|
		end
		# n_neighbor
		# right_neighbor
		
	end

	def build_board
		size.times.collect { [0] * size }
	end

	# what if the same start location?
	def generate_starting_live_cells
		cells = []
		cell_count.times do
			start_x = rand(size) # [0..4]
			start_y = rand(size) # [0..4]
			cell = Cell.new(start_x, start_y)

			cells << cell
			update_board(cell)
		end
		cells
	end

	def update_board(cell)
	  board[cell.y][cell.x] = LIVE_CELL
	end
end