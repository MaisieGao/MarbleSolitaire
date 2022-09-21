package cs5004.marblesolitaire.model;
/**
 * Enum for three possible output on the board：Stone, Empty, NotAvailable
 */
public enum Marble {
    Stone {
        @Override
        public String toString() {
            return "O";
        }
    },
    Empty {
        @Override
        public String toString() {
            return "_";
        }
    },
    NotAvailable {
        @Override
        public String toString() {
            return " ";
        }
    };
}

