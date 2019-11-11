// Generated from C:/Users/Sam/Downloads/langtools-65bfdabaab9c/decafcompiler/src/main/java/grammar\DecafParser.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, BREAK=2, CLASS=3, CONTINUE=4, ELSE=5, EXTENDS=6, IF=7, NEW=8, 
		PRIVATE=9, PROTECTED=10, PUBLIC=11, RETURN=12, STATIC=13, SUPER=14, THIS=15, 
		WHILE=16, BOOLEAN=17, CHAR=18, INT=19, VOID=20, ABSTRACT=21, BYTE=22, 
		CASE=23, CATCH=24, CONST=25, DEFAULT=26, DO=27, DOUBLE=28, FINAL=29, FINALLY=30, 
		FOR=31, IMPLEMENTS=32, IMPORT=33, INSTANCEOF=34, INTERFACE=35, LONG=36, 
		NATIVE=37, GOTO=38, PACKAGE=39, SHORT=40, SWITCH=41, SYNCRHONIZED=42, 
		THROW=43, THROWS=44, TRANSIENT=45, TRY=46, VOLATILE=47, BYVALUE=48, CAST=49, 
		FUTURE=50, GENERIC=51, INNER=52, NONE=53, OPERATOR=54, OUTER=55, REST=56, 
		VAR=57, TRUE=58, FALSE=59, NULL=60, IDENTIFIER=61, COMMENT=62, INTEGER_LITERAL=63, 
		CHARACTER_LITERAL=64, STRING=65, LEFT_PAREN=66, RIGHT_PAREN=67, LEFT_BRACE=68, 
		RIGHT_BRACE=69, LEFT_BRACKET=70, RIGHT_BRACKET=71, SEMICOLON=72, COMMA=73, 
		DOT=74, BIND=75, GREATER_THAN=76, LESS_THAN=77, BANG=78, EQUAL=79, GREATER_THAN_OR_EQUAL_TO=80, 
		LESS_THAN_OR_EQUAL_TO=81, NOT_EQUAL=82, PLUS=83, MINUS=84, TIMES=85, DIVIDE=86, 
		AND=87, OR=88, MOD=89, TILDE=90, QUESTION_MARK=91, COLON=92, PLUS_PLUS=93, 
		MINUS_MINUS=94, AMPERSAND=95, VERTICAL_BAR=96, CARET=97, SHIFT_LEFT=98, 
		SHIFT_RIGHT=99, SHIFT_RIGHT_FILL=100, PLUS_EQUALS=101, MINUS_EQUALS=102, 
		TIMES_EQUALS=103, DIVIDE_EQUALS=104, AMPERSAND_EQUALS=105, VERTICAL_BAR_EQUALS=106, 
		CARET_EQUALS=107, PERCENT_EQUALS=108, SHIFT_LEFT_EQUALS=109, SHIFT_RIGHT_EQUALS=110, 
		SHIFT_RIGHT_FILL_EQUALS=111;
	public static final int
		RULE_start = 0, RULE_classRule = 1, RULE_superRule = 2, RULE_member = 3, 
		RULE_field = 4, RULE_method = 5, RULE_ctor = 6, RULE_modifier = 7, RULE_formalArgs = 8, 
		RULE_formalArgList = 9, RULE_formalArg = 10, RULE_type = 11, RULE_primitiveType = 12, 
		RULE_varDeclarationList = 13, RULE_varDeclarator = 14, RULE_varDeclaratorId = 15, 
		RULE_block = 16, RULE_statement = 17, RULE_expression = 18, RULE_precedence6Op = 19, 
		RULE_precedence5Op = 20, RULE_precedence4Op = 21, RULE_precedence3Op = 22, 
		RULE_precedence2Op = 23, RULE_precedence1Op = 24, RULE_unaryOp = 25, RULE_primary = 26, 
		RULE_newArrayExpr = 27, RULE_dimension = 28, RULE_nonNewArrayExpr = 29, 
		RULE_literal = 30, RULE_actualArgs = 31, RULE_exprList = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "classRule", "superRule", "member", "field", "method", "ctor", 
			"modifier", "formalArgs", "formalArgList", "formalArg", "type", "primitiveType", 
			"varDeclarationList", "varDeclarator", "varDeclaratorId", "block", "statement", 
			"expression", "precedence6Op", "precedence5Op", "precedence4Op", "precedence3Op", 
			"precedence2Op", "precedence1Op", "unaryOp", "primary", "newArrayExpr", 
			"dimension", "nonNewArrayExpr", "literal", "actualArgs", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'break'", "'class'", "'continue'", "'else'", "'extends'", 
			"'if'", "'new'", "'private'", "'protected'", "'public'", "'return'", 
			"'static'", "'super'", "'this'", "'while'", "'boolean'", "'char'", "'int'", 
			"'void'", "'abstract'", "'byte'", "'case'", "'catch'", "'const'", "'default'", 
			"'do'", "'double'", "'final'", "'finally'", "'for'", "'implements'", 
			"'import'", "'instanceof'", "'interface'", "'long'", "'native'", "'goto'", 
			"'package'", "'short'", "'switch'", "'synchronized'", "'throw'", "'throws'", 
			"'transient'", "'try'", "'volatile'", "'byvalue'", "'cast'", "'future'", 
			"'generic'", "'inner'", "'none'", "'operator'", "'outer'", "'rest'", 
			"'var'", "'true'", "'false'", "'null'", null, null, null, null, null, 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'='", 
			"'>'", "'<'", "'!'", "'=='", "'>='", "'<='", "'!='", "'+'", "'-'", "'*'", 
			"'/'", "'&&'", "'||'", "'%'", "'~'", "'?'", "':'", "'++'", "'--'", "'&'", 
			"'|'", "'^'", "'<<'", "'>>'", "'>>>'", "'+='", "'-='", "'*='", "'/='", 
			"'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "BREAK", "CLASS", "CONTINUE", "ELSE", "EXTENDS", 
			"IF", "NEW", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "STATIC", "SUPER", 
			"THIS", "WHILE", "BOOLEAN", "CHAR", "INT", "VOID", "ABSTRACT", "BYTE", 
			"CASE", "CATCH", "CONST", "DEFAULT", "DO", "DOUBLE", "FINAL", "FINALLY", 
			"FOR", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INTERFACE", "LONG", "NATIVE", 
			"GOTO", "PACKAGE", "SHORT", "SWITCH", "SYNCRHONIZED", "THROW", "THROWS", 
			"TRANSIENT", "TRY", "VOLATILE", "BYVALUE", "CAST", "FUTURE", "GENERIC", 
			"INNER", "NONE", "OPERATOR", "OUTER", "REST", "VAR", "TRUE", "FALSE", 
			"NULL", "IDENTIFIER", "COMMENT", "INTEGER_LITERAL", "CHARACTER_LITERAL", 
			"STRING", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", 
			"RIGHT_BRACKET", "SEMICOLON", "COMMA", "DOT", "BIND", "GREATER_THAN", 
			"LESS_THAN", "BANG", "EQUAL", "GREATER_THAN_OR_EQUAL_TO", "LESS_THAN_OR_EQUAL_TO", 
			"NOT_EQUAL", "PLUS", "MINUS", "TIMES", "DIVIDE", "AND", "OR", "MOD", 
			"TILDE", "QUESTION_MARK", "COLON", "PLUS_PLUS", "MINUS_MINUS", "AMPERSAND", 
			"VERTICAL_BAR", "CARET", "SHIFT_LEFT", "SHIFT_RIGHT", "SHIFT_RIGHT_FILL", 
			"PLUS_EQUALS", "MINUS_EQUALS", "TIMES_EQUALS", "DIVIDE_EQUALS", "AMPERSAND_EQUALS", 
			"VERTICAL_BAR_EQUALS", "CARET_EQUALS", "PERCENT_EQUALS", "SHIFT_LEFT_EQUALS", 
			"SHIFT_RIGHT_EQUALS", "SHIFT_RIGHT_FILL_EQUALS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DecafParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public List<ClassRuleContext> classRule() {
			return getRuleContexts(ClassRuleContext.class);
		}
		public ClassRuleContext classRule(int i) {
			return getRuleContext(ClassRuleContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				classRule();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassRuleContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(DecafParser.CLASS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(DecafParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(DecafParser.RIGHT_BRACE, 0); }
		public SuperRuleContext superRule() {
			return getRuleContext(SuperRuleContext.class,0);
		}
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public ClassRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterClassRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitClassRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitClassRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassRuleContext classRule() throws RecognitionException {
		ClassRuleContext _localctx = new ClassRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(CLASS);
			setState(72);
			match(IDENTIFIER);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(73);
				superRule();
				}
			}

			setState(76);
			match(LEFT_BRACE);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(77);
				member();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuperRuleContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(DecafParser.EXTENDS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public SuperRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterSuperRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitSuperRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitSuperRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperRuleContext superRule() throws RecognitionException {
		SuperRuleContext _localctx = new SuperRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_superRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(EXTENDS);
			setState(86);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public CtorContext ctor() {
			return getRuleContext(CtorContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_member);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				field();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				method();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				ctor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationListContext varDeclarationList() {
			return getRuleContext(VarDeclarationListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				{
				setState(93);
				modifier();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			type(0);
			setState(100);
			varDeclarationList();
			setState(101);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public FormalArgsContext formalArgs() {
			return getRuleContext(FormalArgsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				{
				setState(103);
				modifier();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			type(0);
			setState(110);
			match(IDENTIFIER);
			setState(111);
			formalArgs();
			setState(112);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public FormalArgsContext formalArgs() {
			return getRuleContext(FormalArgsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public CtorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCtor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCtor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitCtor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtorContext ctor() throws RecognitionException {
		CtorContext _localctx = new CtorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ctor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) {
				{
				{
				setState(114);
				modifier();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(IDENTIFIER);
			setState(121);
			formalArgs();
			setState(122);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(DecafParser.STATIC, 0); }
		public TerminalNode PUBLIC() { return getToken(DecafParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(DecafParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(DecafParser.PROTECTED, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRIVATE) | (1L << PROTECTED) | (1L << PUBLIC) | (1L << STATIC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalArgsContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(DecafParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(DecafParser.RIGHT_PAREN, 0); }
		public FormalArgListContext formalArgList() {
			return getRuleContext(FormalArgListContext.class,0);
		}
		public FormalArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterFormalArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitFormalArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitFormalArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalArgsContext formalArgs() throws RecognitionException {
		FormalArgsContext _localctx = new FormalArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_formalArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(LEFT_PAREN);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << VOID) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(127);
				formalArgList();
				}
			}

			setState(130);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalArgListContext extends ParserRuleContext {
		public FormalArgContext formalArg() {
			return getRuleContext(FormalArgContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DecafParser.COMMA, 0); }
		public FormalArgListContext formalArgList() {
			return getRuleContext(FormalArgListContext.class,0);
		}
		public FormalArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterFormalArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitFormalArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitFormalArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalArgListContext formalArgList() throws RecognitionException {
		FormalArgListContext _localctx = new FormalArgListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_formalArgList);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				formalArg();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(133);
				formalArg();
				setState(134);
				match(COMMA);
				setState(135);
				formalArgList();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalArgContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclaratorIdContext varDeclaratorId() {
			return getRuleContext(VarDeclaratorIdContext.class,0);
		}
		public FormalArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterFormalArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitFormalArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitFormalArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalArgContext formalArg() throws RecognitionException {
		FormalArgContext _localctx = new FormalArgContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formalArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			type(0);
			setState(140);
			varDeclaratorId(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(DecafParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(DecafParser.RIGHT_BRACKET, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case CHAR:
			case INT:
			case VOID:
				{
				setState(143);
				primitiveType();
				}
				break;
			case IDENTIFIER:
				{
				setState(144);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(147);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(148);
					match(LEFT_BRACKET);
					setState(149);
					match(RIGHT_BRACKET);
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(DecafParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(DecafParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(DecafParser.INT, 0); }
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationListContext extends ParserRuleContext {
		public VarDeclaratorContext varDeclarator() {
			return getRuleContext(VarDeclaratorContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DecafParser.COMMA, 0); }
		public VarDeclarationListContext varDeclarationList() {
			return getRuleContext(VarDeclarationListContext.class,0);
		}
		public VarDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterVarDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitVarDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitVarDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationListContext varDeclarationList() throws RecognitionException {
		VarDeclarationListContext _localctx = new VarDeclarationListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDeclarationList);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				varDeclarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				varDeclarator();
				setState(159);
				match(COMMA);
				setState(160);
				varDeclarationList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclaratorContext extends ParserRuleContext {
		public VarDeclaratorIdContext varDeclaratorId() {
			return getRuleContext(VarDeclaratorIdContext.class,0);
		}
		public TerminalNode BIND() { return getToken(DecafParser.BIND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterVarDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitVarDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitVarDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclaratorContext varDeclarator() throws RecognitionException {
		VarDeclaratorContext _localctx = new VarDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDeclarator);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				varDeclaratorId(0);
				setState(165);
				match(BIND);
				setState(166);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				varDeclaratorId(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public VarDeclaratorIdContext varDeclaratorId() {
			return getRuleContext(VarDeclaratorIdContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(DecafParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(DecafParser.RIGHT_BRACKET, 0); }
		public VarDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterVarDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitVarDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitVarDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclaratorIdContext varDeclaratorId() throws RecognitionException {
		return varDeclaratorId(0);
	}

	private VarDeclaratorIdContext varDeclaratorId(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarDeclaratorIdContext _localctx = new VarDeclaratorIdContext(_ctx, _parentState);
		VarDeclaratorIdContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_varDeclaratorId, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172);
			match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarDeclaratorIdContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varDeclaratorId);
					setState(174);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(175);
					match(LEFT_BRACKET);
					setState(176);
					match(RIGHT_BRACKET);
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(DecafParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(DecafParser.RIGHT_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(LEFT_BRACE);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CONTINUE) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SUPER) | (1L << THIS) | (1L << WHILE) | (1L << BOOLEAN) | (1L << CHAR) | (1L << INT) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTER_LITERAL - 64)) | (1L << (STRING - 64)) | (1L << (LEFT_PAREN - 64)) | (1L << (LEFT_BRACE - 64)) | (1L << (SEMICOLON - 64)) | (1L << (BANG - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)))) != 0)) {
				{
				{
				setState(183);
				statement();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclarationListContext varDeclarationList() {
			return getRuleContext(VarDeclarationListContext.class,0);
		}
		public TerminalNode IF() { return getToken(DecafParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(DecafParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(DecafParser.RIGHT_PAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(DecafParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(DecafParser.WHILE, 0); }
		public TerminalNode RETURN() { return getToken(DecafParser.RETURN, 0); }
		public TerminalNode CONTINUE() { return getToken(DecafParser.CONTINUE, 0); }
		public TerminalNode BREAK() { return getToken(DecafParser.BREAK, 0); }
		public TerminalNode SUPER() { return getToken(DecafParser.SUPER, 0); }
		public ActualArgsContext actualArgs() {
			return getRuleContext(ActualArgsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		int _la;
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				type(0);
				setState(193);
				varDeclarationList();
				setState(194);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(IF);
				setState(197);
				match(LEFT_PAREN);
				setState(198);
				expression(0);
				setState(199);
				match(RIGHT_PAREN);
				setState(200);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				match(IF);
				setState(203);
				match(LEFT_PAREN);
				setState(204);
				expression(0);
				setState(205);
				match(RIGHT_PAREN);
				setState(206);
				statement();
				setState(207);
				match(ELSE);
				setState(208);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				expression(0);
				setState(211);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				match(WHILE);
				setState(214);
				match(LEFT_PAREN);
				setState(215);
				expression(0);
				setState(216);
				match(RIGHT_PAREN);
				setState(217);
				statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				match(RETURN);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTER_LITERAL - 64)) | (1L << (STRING - 64)) | (1L << (LEFT_PAREN - 64)) | (1L << (BANG - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)))) != 0)) {
					{
					setState(220);
					expression(0);
					}
				}

				setState(223);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(224);
				match(CONTINUE);
				setState(225);
				match(SEMICOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(226);
				match(BREAK);
				setState(227);
				match(SEMICOLON);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(228);
				match(SUPER);
				setState(229);
				actualArgs();
				setState(230);
				match(SEMICOLON);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(232);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Precedence6OpContext precedence6Op() {
			return getRuleContext(Precedence6OpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BIND() { return getToken(DecafParser.BIND, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(236);
			precedence6Op(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(238);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(239);
					match(BIND);
					setState(240);
					precedence6Op(0);
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Precedence6OpContext extends ParserRuleContext {
		public Precedence5OpContext precedence5Op() {
			return getRuleContext(Precedence5OpContext.class,0);
		}
		public Precedence6OpContext precedence6Op() {
			return getRuleContext(Precedence6OpContext.class,0);
		}
		public TerminalNode OR() { return getToken(DecafParser.OR, 0); }
		public Precedence6OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence6Op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrecedence6Op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrecedence6Op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrecedence6Op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence6OpContext precedence6Op() throws RecognitionException {
		return precedence6Op(0);
	}

	private Precedence6OpContext precedence6Op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Precedence6OpContext _localctx = new Precedence6OpContext(_ctx, _parentState);
		Precedence6OpContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_precedence6Op, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(247);
			precedence5Op(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Precedence6OpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_precedence6Op);
					setState(249);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(250);
					match(OR);
					setState(251);
					precedence5Op(0);
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Precedence5OpContext extends ParserRuleContext {
		public Precedence4OpContext precedence4Op() {
			return getRuleContext(Precedence4OpContext.class,0);
		}
		public Precedence5OpContext precedence5Op() {
			return getRuleContext(Precedence5OpContext.class,0);
		}
		public TerminalNode AND() { return getToken(DecafParser.AND, 0); }
		public Precedence5OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence5Op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrecedence5Op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrecedence5Op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrecedence5Op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence5OpContext precedence5Op() throws RecognitionException {
		return precedence5Op(0);
	}

	private Precedence5OpContext precedence5Op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Precedence5OpContext _localctx = new Precedence5OpContext(_ctx, _parentState);
		Precedence5OpContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_precedence5Op, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(258);
			precedence4Op(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Precedence5OpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_precedence5Op);
					setState(260);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(261);
					match(AND);
					setState(262);
					precedence4Op(0);
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Precedence4OpContext extends ParserRuleContext {
		public Precedence3OpContext precedence3Op() {
			return getRuleContext(Precedence3OpContext.class,0);
		}
		public Precedence4OpContext precedence4Op() {
			return getRuleContext(Precedence4OpContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(DecafParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(DecafParser.NOT_EQUAL, 0); }
		public Precedence4OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence4Op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrecedence4Op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrecedence4Op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrecedence4Op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence4OpContext precedence4Op() throws RecognitionException {
		return precedence4Op(0);
	}

	private Precedence4OpContext precedence4Op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Precedence4OpContext _localctx = new Precedence4OpContext(_ctx, _parentState);
		Precedence4OpContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_precedence4Op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(269);
			precedence3Op(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Precedence4OpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_precedence4Op);
					setState(271);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(272);
					_la = _input.LA(1);
					if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(273);
					precedence3Op(0);
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Precedence3OpContext extends ParserRuleContext {
		public Precedence2OpContext precedence2Op() {
			return getRuleContext(Precedence2OpContext.class,0);
		}
		public Precedence3OpContext precedence3Op() {
			return getRuleContext(Precedence3OpContext.class,0);
		}
		public TerminalNode LESS_THAN_OR_EQUAL_TO() { return getToken(DecafParser.LESS_THAN_OR_EQUAL_TO, 0); }
		public TerminalNode GREATER_THAN_OR_EQUAL_TO() { return getToken(DecafParser.GREATER_THAN_OR_EQUAL_TO, 0); }
		public TerminalNode LESS_THAN() { return getToken(DecafParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(DecafParser.GREATER_THAN, 0); }
		public Precedence3OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence3Op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrecedence3Op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrecedence3Op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrecedence3Op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence3OpContext precedence3Op() throws RecognitionException {
		return precedence3Op(0);
	}

	private Precedence3OpContext precedence3Op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Precedence3OpContext _localctx = new Precedence3OpContext(_ctx, _parentState);
		Precedence3OpContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_precedence3Op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(280);
			precedence2Op(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Precedence3OpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_precedence3Op);
					setState(282);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(283);
					_la = _input.LA(1);
					if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (GREATER_THAN - 76)) | (1L << (LESS_THAN - 76)) | (1L << (GREATER_THAN_OR_EQUAL_TO - 76)) | (1L << (LESS_THAN_OR_EQUAL_TO - 76)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(284);
					precedence2Op(0);
					}
					} 
				}
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Precedence2OpContext extends ParserRuleContext {
		public Precedence1OpContext precedence1Op() {
			return getRuleContext(Precedence1OpContext.class,0);
		}
		public Precedence2OpContext precedence2Op() {
			return getRuleContext(Precedence2OpContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(DecafParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public Precedence2OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence2Op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrecedence2Op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrecedence2Op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrecedence2Op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence2OpContext precedence2Op() throws RecognitionException {
		return precedence2Op(0);
	}

	private Precedence2OpContext precedence2Op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Precedence2OpContext _localctx = new Precedence2OpContext(_ctx, _parentState);
		Precedence2OpContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_precedence2Op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(291);
			precedence1Op(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Precedence2OpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_precedence2Op);
					setState(293);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(294);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(295);
					precedence1Op(0);
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Precedence1OpContext extends ParserRuleContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public Precedence1OpContext precedence1Op() {
			return getRuleContext(Precedence1OpContext.class,0);
		}
		public TerminalNode MOD() { return getToken(DecafParser.MOD, 0); }
		public TerminalNode DIVIDE() { return getToken(DecafParser.DIVIDE, 0); }
		public TerminalNode TIMES() { return getToken(DecafParser.TIMES, 0); }
		public Precedence1OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precedence1Op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrecedence1Op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrecedence1Op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrecedence1Op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precedence1OpContext precedence1Op() throws RecognitionException {
		return precedence1Op(0);
	}

	private Precedence1OpContext precedence1Op(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Precedence1OpContext _localctx = new Precedence1OpContext(_ctx, _parentState);
		Precedence1OpContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_precedence1Op, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(302);
			unaryOp();
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Precedence1OpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_precedence1Op);
					setState(304);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(305);
					_la = _input.LA(1);
					if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & ((1L << (TIMES - 85)) | (1L << (DIVIDE - 85)) | (1L << (MOD - 85)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(306);
					unaryOp();
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryOpContext extends ParserRuleContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(DecafParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(DecafParser.MINUS, 0); }
		public TerminalNode BANG() { return getToken(DecafParser.BANG, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryOp);
		int _la;
		try {
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BANG:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				_la = _input.LA(1);
				if ( !(((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (BANG - 78)) | (1L << (PLUS - 78)) | (1L << (MINUS - 78)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(313);
				unaryOp();
				}
				break;
			case NEW:
			case SUPER:
			case THIS:
			case TRUE:
			case FALSE:
			case NULL:
			case IDENTIFIER:
			case INTEGER_LITERAL:
			case CHARACTER_LITERAL:
			case STRING:
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public NewArrayExprContext newArrayExpr() {
			return getRuleContext(NewArrayExprContext.class,0);
		}
		public NonNewArrayExprContext nonNewArrayExpr() {
			return getRuleContext(NonNewArrayExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primary);
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				newArrayExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				nonNewArrayExpr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewArrayExprContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(DecafParser.NEW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DecafParser.IDENTIFIER, 0); }
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public NewArrayExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newArrayExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterNewArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitNewArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitNewArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewArrayExprContext newArrayExpr() throws RecognitionException {
		NewArrayExprContext _localctx = new NewArrayExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_newArrayExpr);
		try {
			int _alt;
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				match(NEW);
				setState(323);
				match(IDENTIFIER);
				setState(325); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(324);
						dimension();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(327); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				match(NEW);
				setState(330);
				primitiveType();
				setState(332); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(331);
						dimension();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(334); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimensionContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(DecafParser.LEFT_BRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(DecafParser.RIGHT_BRACE, 0); }
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(LEFT_BRACE);
			setState(339);
			expression(0);
			setState(340);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonNewArrayExprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode THIS() { return getToken(DecafParser.THIS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(DecafParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(DecafParser.RIGHT_PAREN, 0); }
		public TerminalNode NEW() { return getToken(DecafParser.NEW, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(DecafParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(DecafParser.IDENTIFIER, i);
		}
		public ActualArgsContext actualArgs() {
			return getRuleContext(ActualArgsContext.class,0);
		}
		public TerminalNode DOT() { return getToken(DecafParser.DOT, 0); }
		public NewArrayExprContext newArrayExpr() {
			return getRuleContext(NewArrayExprContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(DecafParser.SUPER, 0); }
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public NonNewArrayExprContext nonNewArrayExpr() {
			return getRuleContext(NonNewArrayExprContext.class,0);
		}
		public NonNewArrayExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonNewArrayExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterNonNewArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitNonNewArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitNonNewArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonNewArrayExprContext nonNewArrayExpr() throws RecognitionException {
		return nonNewArrayExpr(0);
	}

	private NonNewArrayExprContext nonNewArrayExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NonNewArrayExprContext _localctx = new NonNewArrayExprContext(_ctx, _parentState);
		NonNewArrayExprContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_nonNewArrayExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(343);
				literal();
				}
				break;
			case 2:
				{
				setState(344);
				match(THIS);
				}
				break;
			case 3:
				{
				setState(345);
				match(LEFT_PAREN);
				setState(346);
				expression(0);
				setState(347);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				{
				setState(349);
				match(NEW);
				setState(350);
				match(IDENTIFIER);
				setState(351);
				actualArgs();
				}
				break;
			case 5:
				{
				setState(352);
				match(IDENTIFIER);
				setState(353);
				actualArgs();
				}
				break;
			case 6:
				{
				setState(356);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEW:
					{
					setState(354);
					newArrayExpr();
					}
					break;
				case IDENTIFIER:
					{
					setState(355);
					match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(358);
				match(DOT);
				setState(359);
				match(IDENTIFIER);
				setState(360);
				actualArgs();
				}
				break;
			case 7:
				{
				setState(361);
				match(SUPER);
				setState(362);
				match(DOT);
				setState(363);
				match(IDENTIFIER);
				setState(364);
				actualArgs();
				}
				break;
			case 8:
				{
				setState(365);
				match(IDENTIFIER);
				setState(366);
				dimension();
				}
				break;
			case 9:
				{
				setState(367);
				match(SUPER);
				setState(368);
				match(DOT);
				setState(369);
				match(IDENTIFIER);
				}
				break;
			case 10:
				{
				setState(370);
				match(IDENTIFIER);
				setState(371);
				match(DOT);
				setState(372);
				match(IDENTIFIER);
				}
				break;
			case 11:
				{
				setState(373);
				newArrayExpr();
				setState(374);
				match(DOT);
				setState(375);
				match(IDENTIFIER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(388);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new NonNewArrayExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nonNewArrayExpr);
						setState(379);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(380);
						match(DOT);
						setState(381);
						match(IDENTIFIER);
						setState(382);
						actualArgs();
						}
						break;
					case 2:
						{
						_localctx = new NonNewArrayExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nonNewArrayExpr);
						setState(383);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(384);
						dimension();
						}
						break;
					case 3:
						{
						_localctx = new NonNewArrayExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_nonNewArrayExpr);
						setState(385);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(386);
						match(DOT);
						setState(387);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(DecafParser.NULL, 0); }
		public TerminalNode TRUE() { return getToken(DecafParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(DecafParser.FALSE, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(DecafParser.INTEGER_LITERAL, 0); }
		public TerminalNode CHARACTER_LITERAL() { return getToken(DecafParser.CHARACTER_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(DecafParser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_la = _input.LA(1);
			if ( !(((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & ((1L << (TRUE - 58)) | (1L << (FALSE - 58)) | (1L << (NULL - 58)) | (1L << (INTEGER_LITERAL - 58)) | (1L << (CHARACTER_LITERAL - 58)) | (1L << (STRING - 58)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualArgsContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(DecafParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(DecafParser.RIGHT_PAREN, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ActualArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterActualArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitActualArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitActualArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualArgsContext actualArgs() throws RecognitionException {
		ActualArgsContext _localctx = new ActualArgsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_actualArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(LEFT_PAREN);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEW) | (1L << SUPER) | (1L << THIS) | (1L << TRUE) | (1L << FALSE) | (1L << NULL) | (1L << IDENTIFIER) | (1L << INTEGER_LITERAL))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (CHARACTER_LITERAL - 64)) | (1L << (STRING - 64)) | (1L << (LEFT_PAREN - 64)) | (1L << (BANG - 64)) | (1L << (PLUS - 64)) | (1L << (MINUS - 64)))) != 0)) {
				{
				setState(396);
				exprList();
				}
			}

			setState(399);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(DecafParser.COMMA, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DecafParserVisitor ) return ((DecafParserVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_exprList);
		try {
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(402);
				expression(0);
				setState(403);
				match(COMMA);
				setState(404);
				exprList();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 15:
			return varDeclaratorId_sempred((VarDeclaratorIdContext)_localctx, predIndex);
		case 18:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 19:
			return precedence6Op_sempred((Precedence6OpContext)_localctx, predIndex);
		case 20:
			return precedence5Op_sempred((Precedence5OpContext)_localctx, predIndex);
		case 21:
			return precedence4Op_sempred((Precedence4OpContext)_localctx, predIndex);
		case 22:
			return precedence3Op_sempred((Precedence3OpContext)_localctx, predIndex);
		case 23:
			return precedence2Op_sempred((Precedence2OpContext)_localctx, predIndex);
		case 24:
			return precedence1Op_sempred((Precedence1OpContext)_localctx, predIndex);
		case 29:
			return nonNewArrayExpr_sempred((NonNewArrayExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean varDeclaratorId_sempred(VarDeclaratorIdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean precedence6Op_sempred(Precedence6OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean precedence5Op_sempred(Precedence5OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean precedence4Op_sempred(Precedence4OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean precedence3Op_sempred(Precedence3OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean precedence2Op_sempred(Precedence2OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean precedence1Op_sempred(Precedence1OpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean nonNewArrayExpr_sempred(NonNewArrayExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3q\u019b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\6\2F\n\2\r\2\16\2G\3\3\3\3\3\3\5\3M\n\3\3\3\3\3\7\3Q\n"+
		"\3\f\3\16\3T\13\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\5\5^\n\5\3\6\7\6a\n"+
		"\6\f\6\16\6d\13\6\3\6\3\6\3\6\3\6\3\7\7\7k\n\7\f\7\16\7n\13\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\7\bv\n\b\f\b\16\by\13\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\5\n\u0083\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u008c\n\13\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\5\r\u0094\n\r\3\r\3\r\3\r\7\r\u0099\n\r\f\r\16\r"+
		"\u009c\13\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00a5\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u00ac\n\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u00b4\n\21\f\21\16\21\u00b7\13\21\3\22\3\22\7\22\u00bb\n\22\f\22\16\22"+
		"\u00be\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e0\n\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ec\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\7\24\u00f4\n\24\f\24\16\24\u00f7\13\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u00ff\n\25\f\25\16\25\u0102\13\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u010a\n\26\f\26\16\26\u010d\13\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0115\n\27\f\27\16\27\u0118\13\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u0120\n\30\f\30\16\30\u0123\13\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\7\31\u012b\n\31\f\31\16\31\u012e\13\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\7\32\u0136\n\32\f\32\16\32\u0139\13\32\3\33\3\33\3\33\5\33\u013e"+
		"\n\33\3\34\3\34\3\34\5\34\u0143\n\34\3\35\3\35\3\35\6\35\u0148\n\35\r"+
		"\35\16\35\u0149\3\35\3\35\3\35\6\35\u014f\n\35\r\35\16\35\u0150\5\35\u0153"+
		"\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0167\n\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u017c\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0187\n"+
		"\37\f\37\16\37\u018a\13\37\3 \3 \3!\3!\5!\u0190\n!\3!\3!\3\"\3\"\3\"\3"+
		"\"\3\"\5\"\u0199\n\"\3\"\2\f\30 &(*,.\60\62<#\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\n\4\2\13\r\17\17\3\2\23\26"+
		"\4\2QQTT\4\2NORS\3\2UV\4\2WX[[\4\2PPUV\4\2<>AC\2\u01b1\2E\3\2\2\2\4I\3"+
		"\2\2\2\6W\3\2\2\2\b]\3\2\2\2\nb\3\2\2\2\fl\3\2\2\2\16w\3\2\2\2\20~\3\2"+
		"\2\2\22\u0080\3\2\2\2\24\u008b\3\2\2\2\26\u008d\3\2\2\2\30\u0093\3\2\2"+
		"\2\32\u009d\3\2\2\2\34\u00a4\3\2\2\2\36\u00ab\3\2\2\2 \u00ad\3\2\2\2\""+
		"\u00b8\3\2\2\2$\u00eb\3\2\2\2&\u00ed\3\2\2\2(\u00f8\3\2\2\2*\u0103\3\2"+
		"\2\2,\u010e\3\2\2\2.\u0119\3\2\2\2\60\u0124\3\2\2\2\62\u012f\3\2\2\2\64"+
		"\u013d\3\2\2\2\66\u0142\3\2\2\28\u0152\3\2\2\2:\u0154\3\2\2\2<\u017b\3"+
		"\2\2\2>\u018b\3\2\2\2@\u018d\3\2\2\2B\u0198\3\2\2\2DF\5\4\3\2ED\3\2\2"+
		"\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\3\3\2\2\2IJ\7\5\2\2JL\7?\2\2KM\5\6\4"+
		"\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NR\7F\2\2OQ\5\b\5\2PO\3\2\2\2QT\3\2\2"+
		"\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TR\3\2\2\2UV\7G\2\2V\5\3\2\2\2WX\7\b\2"+
		"\2XY\7?\2\2Y\7\3\2\2\2Z^\5\n\6\2[^\5\f\7\2\\^\5\16\b\2]Z\3\2\2\2][\3\2"+
		"\2\2]\\\3\2\2\2^\t\3\2\2\2_a\5\20\t\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc"+
		"\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\5\30\r\2fg\5\34\17\2gh\7J\2\2h\13\3\2\2"+
		"\2ik\5\20\t\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2"+
		"\2\2op\5\30\r\2pq\7?\2\2qr\5\22\n\2rs\5\"\22\2s\r\3\2\2\2tv\5\20\t\2u"+
		"t\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7?\2\2{"+
		"|\5\22\n\2|}\5\"\22\2}\17\3\2\2\2~\177\t\2\2\2\177\21\3\2\2\2\u0080\u0082"+
		"\7D\2\2\u0081\u0083\5\24\13\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0085\7E\2\2\u0085\23\3\2\2\2\u0086\u008c\5"+
		"\26\f\2\u0087\u0088\5\26\f\2\u0088\u0089\7K\2\2\u0089\u008a\5\24\13\2"+
		"\u008a\u008c\3\2\2\2\u008b\u0086\3\2\2\2\u008b\u0087\3\2\2\2\u008c\25"+
		"\3\2\2\2\u008d\u008e\5\30\r\2\u008e\u008f\5 \21\2\u008f\27\3\2\2\2\u0090"+
		"\u0091\b\r\1\2\u0091\u0094\5\32\16\2\u0092\u0094\7?\2\2\u0093\u0090\3"+
		"\2\2\2\u0093\u0092\3\2\2\2\u0094\u009a\3\2\2\2\u0095\u0096\f\3\2\2\u0096"+
		"\u0097\7H\2\2\u0097\u0099\7I\2\2\u0098\u0095\3\2\2\2\u0099\u009c\3\2\2"+
		"\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\31\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u009e\t\3\2\2\u009e\33\3\2\2\2\u009f\u00a5\5\36\20\2\u00a0"+
		"\u00a1\5\36\20\2\u00a1\u00a2\7K\2\2\u00a2\u00a3\5\34\17\2\u00a3\u00a5"+
		"\3\2\2\2\u00a4\u009f\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a5\35\3\2\2\2\u00a6"+
		"\u00a7\5 \21\2\u00a7\u00a8\7M\2\2\u00a8\u00a9\5&\24\2\u00a9\u00ac\3\2"+
		"\2\2\u00aa\u00ac\5 \21\2\u00ab\u00a6\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\37\3\2\2\2\u00ad\u00ae\b\21\1\2\u00ae\u00af\7?\2\2\u00af\u00b5\3\2\2"+
		"\2\u00b0\u00b1\f\3\2\2\u00b1\u00b2\7H\2\2\u00b2\u00b4\7I\2\2\u00b3\u00b0"+
		"\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"!\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00bc\7F\2\2\u00b9\u00bb\5$\23\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7G\2\2\u00c0"+
		"#\3\2\2\2\u00c1\u00ec\7J\2\2\u00c2\u00c3\5\30\r\2\u00c3\u00c4\5\34\17"+
		"\2\u00c4\u00c5\7J\2\2\u00c5\u00ec\3\2\2\2\u00c6\u00c7\7\t\2\2\u00c7\u00c8"+
		"\7D\2\2\u00c8\u00c9\5&\24\2\u00c9\u00ca\7E\2\2\u00ca\u00cb\5$\23\2\u00cb"+
		"\u00ec\3\2\2\2\u00cc\u00cd\7\t\2\2\u00cd\u00ce\7D\2\2\u00ce\u00cf\5&\24"+
		"\2\u00cf\u00d0\7E\2\2\u00d0\u00d1\5$\23\2\u00d1\u00d2\7\7\2\2\u00d2\u00d3"+
		"\5$\23\2\u00d3\u00ec\3\2\2\2\u00d4\u00d5\5&\24\2\u00d5\u00d6\7J\2\2\u00d6"+
		"\u00ec\3\2\2\2\u00d7\u00d8\7\22\2\2\u00d8\u00d9\7D\2\2\u00d9\u00da\5&"+
		"\24\2\u00da\u00db\7E\2\2\u00db\u00dc\5$\23\2\u00dc\u00ec\3\2\2\2\u00dd"+
		"\u00df\7\16\2\2\u00de\u00e0\5&\24\2\u00df\u00de\3\2\2\2\u00df\u00e0\3"+
		"\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00ec\7J\2\2\u00e2\u00e3\7\6\2\2\u00e3"+
		"\u00ec\7J\2\2\u00e4\u00e5\7\4\2\2\u00e5\u00ec\7J\2\2\u00e6\u00e7\7\20"+
		"\2\2\u00e7\u00e8\5@!\2\u00e8\u00e9\7J\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00ec"+
		"\5\"\22\2\u00eb\u00c1\3\2\2\2\u00eb\u00c2\3\2\2\2\u00eb\u00c6\3\2\2\2"+
		"\u00eb\u00cc\3\2\2\2\u00eb\u00d4\3\2\2\2\u00eb\u00d7\3\2\2\2\u00eb\u00dd"+
		"\3\2\2\2\u00eb\u00e2\3\2\2\2\u00eb\u00e4\3\2\2\2\u00eb\u00e6\3\2\2\2\u00eb"+
		"\u00ea\3\2\2\2\u00ec%\3\2\2\2\u00ed\u00ee\b\24\1\2\u00ee\u00ef\5(\25\2"+
		"\u00ef\u00f5\3\2\2\2\u00f0\u00f1\f\4\2\2\u00f1\u00f2\7M\2\2\u00f2\u00f4"+
		"\5(\25\2\u00f3\u00f0\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\'\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\b\25\1"+
		"\2\u00f9\u00fa\5*\26\2\u00fa\u0100\3\2\2\2\u00fb\u00fc\f\4\2\2\u00fc\u00fd"+
		"\7Z\2\2\u00fd\u00ff\5*\26\2\u00fe\u00fb\3\2\2\2\u00ff\u0102\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101)\3\2\2\2\u0102\u0100\3\2\2\2"+
		"\u0103\u0104\b\26\1\2\u0104\u0105\5,\27\2\u0105\u010b\3\2\2\2\u0106\u0107"+
		"\f\4\2\2\u0107\u0108\7Y\2\2\u0108\u010a\5,\27\2\u0109\u0106\3\2\2\2\u010a"+
		"\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c+\3\2\2\2"+
		"\u010d\u010b\3\2\2\2\u010e\u010f\b\27\1\2\u010f\u0110\5.\30\2\u0110\u0116"+
		"\3\2\2\2\u0111\u0112\f\4\2\2\u0112\u0113\t\4\2\2\u0113\u0115\5.\30\2\u0114"+
		"\u0111\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117-\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\b\30\1\2\u011a\u011b"+
		"\5\60\31\2\u011b\u0121\3\2\2\2\u011c\u011d\f\4\2\2\u011d\u011e\t\5\2\2"+
		"\u011e\u0120\5\60\31\2\u011f\u011c\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f"+
		"\3\2\2\2\u0121\u0122\3\2\2\2\u0122/\3\2\2\2\u0123\u0121\3\2\2\2\u0124"+
		"\u0125\b\31\1\2\u0125\u0126\5\62\32\2\u0126\u012c\3\2\2\2\u0127\u0128"+
		"\f\4\2\2\u0128\u0129\t\6\2\2\u0129\u012b\5\62\32\2\u012a\u0127\3\2\2\2"+
		"\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\61"+
		"\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\b\32\1\2\u0130\u0131\5\64\33"+
		"\2\u0131\u0137\3\2\2\2\u0132\u0133\f\4\2\2\u0133\u0134\t\7\2\2\u0134\u0136"+
		"\5\64\33\2\u0135\u0132\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2"+
		"\u0137\u0138\3\2\2\2\u0138\63\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b"+
		"\t\b\2\2\u013b\u013e\5\64\33\2\u013c\u013e\5\66\34\2\u013d\u013a\3\2\2"+
		"\2\u013d\u013c\3\2\2\2\u013e\65\3\2\2\2\u013f\u0143\58\35\2\u0140\u0143"+
		"\5<\37\2\u0141\u0143\7?\2\2\u0142\u013f\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0141\3\2\2\2\u0143\67\3\2\2\2\u0144\u0145\7\n\2\2\u0145\u0147\7?\2\2"+
		"\u0146\u0148\5:\36\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0147"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0153\3\2\2\2\u014b\u014c\7\n\2\2\u014c"+
		"\u014e\5\32\16\2\u014d\u014f\5:\36\2\u014e\u014d\3\2\2\2\u014f\u0150\3"+
		"\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152"+
		"\u0144\3\2\2\2\u0152\u014b\3\2\2\2\u01539\3\2\2\2\u0154\u0155\7F\2\2\u0155"+
		"\u0156\5&\24\2\u0156\u0157\7G\2\2\u0157;\3\2\2\2\u0158\u0159\b\37\1\2"+
		"\u0159\u017c\5> \2\u015a\u017c\7\21\2\2\u015b\u015c\7D\2\2\u015c\u015d"+
		"\5&\24\2\u015d\u015e\7E\2\2\u015e\u017c\3\2\2\2\u015f\u0160\7\n\2\2\u0160"+
		"\u0161\7?\2\2\u0161\u017c\5@!\2\u0162\u0163\7?\2\2\u0163\u017c\5@!\2\u0164"+
		"\u0167\58\35\2\u0165\u0167\7?\2\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2"+
		"\2\2\u0167\u0168\3\2\2\2\u0168\u0169\7L\2\2\u0169\u016a\7?\2\2\u016a\u017c"+
		"\5@!\2\u016b\u016c\7\20\2\2\u016c\u016d\7L\2\2\u016d\u016e\7?\2\2\u016e"+
		"\u017c\5@!\2\u016f\u0170\7?\2\2\u0170\u017c\5:\36\2\u0171\u0172\7\20\2"+
		"\2\u0172\u0173\7L\2\2\u0173\u017c\7?\2\2\u0174\u0175\7?\2\2\u0175\u0176"+
		"\7L\2\2\u0176\u017c\7?\2\2\u0177\u0178\58\35\2\u0178\u0179\7L\2\2\u0179"+
		"\u017a\7?\2\2\u017a\u017c\3\2\2\2\u017b\u0158\3\2\2\2\u017b\u015a\3\2"+
		"\2\2\u017b\u015b\3\2\2\2\u017b\u015f\3\2\2\2\u017b\u0162\3\2\2\2\u017b"+
		"\u0166\3\2\2\2\u017b\u016b\3\2\2\2\u017b\u016f\3\2\2\2\u017b\u0171\3\2"+
		"\2\2\u017b\u0174\3\2\2\2\u017b\u0177\3\2\2\2\u017c\u0188\3\2\2\2\u017d"+
		"\u017e\f\13\2\2\u017e\u017f\7L\2\2\u017f\u0180\7?\2\2\u0180\u0187\5@!"+
		"\2\u0181\u0182\f\7\2\2\u0182\u0187\5:\36\2\u0183\u0184\f\3\2\2\u0184\u0185"+
		"\7L\2\2\u0185\u0187\7?\2\2\u0186\u017d\3\2\2\2\u0186\u0181\3\2\2\2\u0186"+
		"\u0183\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189=\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c\t\t\2\2\u018c?\3\2"+
		"\2\2\u018d\u018f\7D\2\2\u018e\u0190\5B\"\2\u018f\u018e\3\2\2\2\u018f\u0190"+
		"\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192\7E\2\2\u0192A\3\2\2\2\u0193\u0199"+
		"\5&\24\2\u0194\u0195\5&\24\2\u0195\u0196\7K\2\2\u0196\u0197\5B\"\2\u0197"+
		"\u0199\3\2\2\2\u0198\u0193\3\2\2\2\u0198\u0194\3\2\2\2\u0199C\3\2\2\2"+
		"%GLR]blw\u0082\u008b\u0093\u009a\u00a4\u00ab\u00b5\u00bc\u00df\u00eb\u00f5"+
		"\u0100\u010b\u0116\u0121\u012c\u0137\u013d\u0142\u0149\u0150\u0152\u0166"+
		"\u017b\u0186\u0188\u018f\u0198";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}