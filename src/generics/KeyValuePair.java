package generics;

public class KeyValuePair<K, V> {
  private final K key;
  private final V value;

  public KeyValuePair(K key, V value) {
    this.key = key;
    this.value = value;
  }




  @Override
  public String toString() {
    String result="key is".concat((String) this.key).concat(" ").concat("and value is").concat(String.valueOf((int) this.value));
    return result;
  }
}
