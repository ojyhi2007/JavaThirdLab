package ru.melnikov.directory;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneDirectory {

    // имя -> телефон
    private final Map<String, String> nameToPhone = new LinkedHashMap<>();
    // телефон -> имя
    private final Map<String, String> phoneToName = new LinkedHashMap<>();

    public PhoneDirectory() {
    }

    /**
     * Добавление пары "телефон-имя".
     * Если имя уже было — телефон заменяется, старый телефон возвращается.
     * Если телефон уже был привязан к другому имени — старая пара удаляется.
     */
    public String add(String phone, String name) {
        validate(phone, name);

        // если телефон уже занят другим именем — удаляем старую связку
        if (phoneToName.containsKey(phone)) {
            String oldName = phoneToName.get(phone);
            if (!oldName.equals(name)) {
                nameToPhone.remove(oldName);
                phoneToName.remove(phone);
            }
        }

        String oldPhone = nameToPhone.get(name);

        // если имя уже было, убираем обратную связь старого телефона
        if (oldPhone != null) {
            phoneToName.remove(oldPhone);
        }

        nameToPhone.put(name, phone);
        phoneToName.put(phone, name);

        return oldPhone; // null если имени не было
    }

    /** Удаление по имени (удаляется вся пара). */
    public void removeByName(String name) {
        if (name == null) return;

        String phone = nameToPhone.remove(name);
        if (phone != null) {
            phoneToName.remove(phone);
        }
    }

    /** Получение телефона по имени. Если нет — null. */
    public String getPhoneByName(String name) {
        return nameToPhone.get(name);
    }

    public boolean containsName(String name) {
        return nameToPhone.containsKey(name);
    }

    public boolean containsPhone(String phone) {
        return phoneToName.containsKey(phone);
    }

    public int size() {
        return nameToPhone.size();
    }

    /** Все пары строками: "телефон - имя" */
    public String[] getAllPairs() {
        String[] result = new String[nameToPhone.size()];
        int i = 0;
        for (Map.Entry<String, String> e : nameToPhone.entrySet()) {
            result[i++] = e.getValue() + " - " + e.getKey();
        }
        return result;
    }

    public String[] getAllPhones() {
        String[] result = new String[nameToPhone.size()];
        int i = 0;
        for (String phone : nameToPhone.values()) {
            result[i++] = phone;
        }
        return result;
    }

    public String[] getAllNames() {
        String[] result = new String[nameToPhone.size()];
        int i = 0;
        for (String name : nameToPhone.keySet()) {
            result[i++] = name;
        }
        return result;
    }

    /** Имена, которые начинаются с prefix (с первого символа). */
    public String[] getNamesByPrefix(String prefix) {
        if (prefix == null) prefix = "";

        String[] tmp = new String[nameToPhone.size()];
        int count = 0;

        for (String name : nameToPhone.keySet()) {
            if (name.startsWith(prefix)) {
                tmp[count++] = name;
            }
        }

        return Arrays.copyOf(tmp, count);
    }

    @Override
    public String toString() {
        return Arrays.toString(getAllPairs());
    }

    private void validate(String phone, String name) {
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Телефон не должен быть пустым");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
    }
}