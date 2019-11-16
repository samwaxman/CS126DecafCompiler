package staticchecks;

/*import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StaticState {
    private String currentClass = null;
    private Map<String, ClassInfo> classes = new HashMap<>();
    private Map<String, ResolvedType> environment = new HashMap<>();
    private boolean isInsideBreakableStatement = false;

    // To know if a super constructor call is allowed.
    private boolean isFirstStatementInConstructorCall = false;
    private Optional<ResolvedType> returnType;

    public StaticState() {}
    private StaticState(String currentClass,
                        Map<String, ClassInfo> classes,
                        Map<String, ResolvedType> environment,
                        boolean isInsideBreakableStatement,
                        boolean isFirstStatementInConstructorCall,
                        Optional<ResolvedType> returnType) {
        this.currentClass = currentClass;
        this.classes = classes;
        this.environment = environment;
        this.isInsideBreakableStatement = isInsideBreakableStatement;
        this.isFirstStatementInConstructorCall = isFirstStatementInConstructorCall;
        this.returnType = returnType;
    }

    private StaticState copy(StaticState s) {
        return new StaticState(currentClass,
                               classes,
                               environment,
                               isInsideBreakableStatement,
                               isFirstStatementInConstructorCall,
                               returnType);
    }

    private void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    private void setClasses(Map<String, ClassInfo> classes) {
        this.classes = classes;
    }

    private void setEnvironment(Map<String, ResolvedType> environment) {
        this.environment = environment;
    }

    private void setInsideBreakableStatement(boolean insideBreakableStatement) {
        isInsideBreakableStatement = insideBreakableStatement;
    }

    private void setFirstStatementInConstructorCall(boolean firstStatementInConstructorCall) {
        isFirstStatementInConstructorCall = firstStatementInConstructorCall;
    }

    private void setReturnType(Optional<ResolvedType> returnType) {
        this.returnType = returnType;
    }

    public StaticState withCurrentClass(String currentClass) {
        StaticState copiedState = copy(this);
        copiedState.setCurrentClass(currentClass);
        return copiedState;
    }

    public StaticState withReturnType(ResolvedType returnType) {
        StaticState copiedState = copy(this);
        copiedState.setReturnType(Optional.of(returnType));
        return copiedState;
    }

    public StaticState withInsideBreakableStatement() {
        StaticState copiedState = copy(this);
        copiedState.setInsideBreakableStatement(true);
        return copiedState;
    }

    public StaticState withFirstStatementInConstructorCall() {
        StaticState copiedState = copy(this);
        copiedState.setFirstStatementInConstructorCall(true);
        return copiedState;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public Map<String, ClassInfo> getClasses() {
        return classes;
    }

    public Map<String, ResolvedType> getEnvironment() {
        return environment;
    }

    public boolean isInsideBreakableStatement() {
        return isInsideBreakableStatement;
    }

    public boolean isFirstStatementInConstructorCall() {
        return isFirstStatementInConstructorCall;
    }

    public Optional<ResolvedType> getReturnType() {
        return returnType;
    }
}*/
