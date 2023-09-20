public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Test per il metodo size()
        assert list.size() == 0 : "Test size() fallito";

        // Test per il metodo isEmpty()
        assert list.isEmpty() : "Test isEmpty() fallito";

        // Test per il metodo add()
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.size() == 3 : "Test add() fallito";

        // Test per il metodo get()
        assert list.get(0) == 1 : "Test get() fallito";
        assert list.get(1) == 2 : "Test get() fallito";
        assert list.get(2) == 3 : "Test get() fallito";

        // Test per il metodo remove()
        assert list.remove(2) : "Test remove() fallito";
        assert list.size() == 2 : "Test remove() fallito";
        assert !list.remove(4) : "Test remove() fallito";

        // Test per gestire eccezioni IndexOutOfBoundsException
        try {
            list.get(10);
            assert false : "Test IndexOutOfBoundsException fallito";
        } catch (IndexOutOfBoundsException e) {
            // L'eccezione è stata gestita correttamente
            System.out.println("Test IndexOutOfBoundsException passato");
        }

        // Tutti i test sono passati
        System.out.println("Tutti i test sono passati");
    }
}
