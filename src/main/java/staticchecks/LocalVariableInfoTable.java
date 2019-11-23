package staticchecks;

import astPojos.VariableDeclarationStatement;
import staticchecks.resolvedInfo.*;

import java.util.*;

public class LocalVariableInfoTable {

    private int nextIndex = 0;
    private final LinkedList<Map<String, LocalVariableInfo>> environment = new LinkedList<>();

    public LocalVariableInfoTable(boolean isVirtual, List<ResolvedParam> args) {
        if (isVirtual) {
            // If it's virtual, the first index belongs to the object.
            nextIndex = 1;
        }
        enterBlock();
        for (ResolvedParam a : args) {
           addLocalVariable(a.getName(), a.getType());
        }
    }


    public void enterBlock() {
        environment.add(new HashMap<>());
    }

    public void exitBlock() {
        assert environment.size() != 0;
        environment.removeLast();
    }

    // Isn't this a pretty method?
    public Optional<LocalVariableInfo> findVariable(String name) {
        Iterator<Map<String, LocalVariableInfo>> iter = environment.descendingIterator();
        while (iter.hasNext()) {
            Map<String, LocalVariableInfo> scope = iter.next();
            LocalVariableInfo info = scope.get(name);
            if (info != null) {
                return Optional.of(info);
            }
        }
        return Optional.empty();
    }


    //TODO: Should also take in line information for the error.
    private int addLocalVariable(String name, ResolvedType rt) {
        Map<String, LocalVariableInfo> currentScope = environment.getLast();
        if (currentScope.containsKey(name)) {
            throw new RuntimeException("Duplicate variable in same block: " + name);
        }
        LocalVariableInfo info = LocalVariableInfo.builder()
                                                  .setIndex(nextIndex)
                                                  .setType(rt)
                                                  .build();
        currentScope.put(name, info);
        return nextIndex++;
    }

    public void addLocalVariable(VariableDeclarationStatement vds) {
        vds.setIndex(addLocalVariable(vds.getVariableName(), vds.getResolvedType()));
    }
}
