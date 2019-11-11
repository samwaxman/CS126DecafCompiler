// Generated from C:/Users/Sam/Downloads/langtools-65bfdabaab9c/decafcompiler/src/main/java/grammar\DecafLexer.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHITESPACE", "BREAK", "CLASS", "CONTINUE", "ELSE", "EXTENDS", "IF", 
			"NEW", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "STATIC", "SUPER", 
			"THIS", "WHILE", "BOOLEAN", "CHAR", "INT", "VOID", "ABSTRACT", "BYTE", 
			"CASE", "CATCH", "CONST", "DEFAULT", "DO", "DOUBLE", "FINAL", "FINALLY", 
			"FOR", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INTERFACE", "LONG", "NATIVE", 
			"GOTO", "PACKAGE", "SHORT", "SWITCH", "SYNCRHONIZED", "THROW", "THROWS", 
			"TRANSIENT", "TRY", "VOLATILE", "BYVALUE", "CAST", "FUTURE", "GENERIC", 
			"INNER", "NONE", "OPERATOR", "OUTER", "REST", "VAR", "TRUE", "FALSE", 
			"NULL", "IdentifierStart", "IdentifierContinue", "IDENTIFIER", "MultiLineCommentStart", 
			"MultilineCommentEnd", "MultiLineComment", "COMMENT", "INTEGER_LITERAL", 
			"NEWLINE", "TAB", "ESCAPED_CHAR", "REGULAR_CHAR", "CHARACTER_LITERAL", 
			"EscapedDoubleQuote", "STRING", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", 
			"RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", "SEMICOLON", "COMMA", 
			"DOT", "BIND", "GREATER_THAN", "LESS_THAN", "BANG", "EQUAL", "GREATER_THAN_OR_EQUAL_TO", 
			"LESS_THAN_OR_EQUAL_TO", "NOT_EQUAL", "PLUS", "MINUS", "TIMES", "DIVIDE", 
			"AND", "OR", "MOD", "TILDE", "QUESTION_MARK", "COLON", "PLUS_PLUS", "MINUS_MINUS", 
			"AMPERSAND", "VERTICAL_BAR", "CARET", "SHIFT_LEFT", "SHIFT_RIGHT", "SHIFT_RIGHT_FILL", 
			"PLUS_EQUALS", "MINUS_EQUALS", "TIMES_EQUALS", "DIVIDE_EQUALS", "AMPERSAND_EQUALS", 
			"VERTICAL_BAR_EQUALS", "CARET_EQUALS", "PERCENT_EQUALS", "SHIFT_LEFT_EQUALS", 
			"SHIFT_RIGHT_EQUALS", "SHIFT_RIGHT_FILL_EQUALS"
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


	public DecafLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DecafLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2q\u0359\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3"+
		"&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)"+
		"\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,"+
		"\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/"+
		"\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\38\38\38\38\38\38\39\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3;\3"+
		";\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3>\5>\u0282\n>\3?\3?\5?\u0286\n?\3"+
		"@\3@\7@\u028a\n@\f@\16@\u028d\13@\3A\3A\3A\3B\3B\3B\3C\3C\7C\u0297\nC"+
		"\fC\16C\u029a\13C\3C\3C\3D\3D\3D\3D\3D\7D\u02a3\nD\fD\16D\u02a6\13D\3"+
		"D\5D\u02a9\nD\3E\3E\3E\7E\u02ae\nE\fE\16E\u02b1\13E\5E\u02b3\nE\3F\3F"+
		"\3F\3F\3F\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3J\3J\3J\3J\5J"+
		"\u02cd\nJ\3K\3K\7K\u02d1\nK\fK\16K\u02d4\13K\3K\3K\3K\3L\3L\3L\7L\u02dc"+
		"\nL\fL\16L\u02df\13L\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3"+
		"T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3Z\3[\3[\3[\3\\\3\\\3\\\3]\3"+
		"]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\3b\3c\3c\3c\3d\3d\3e\3e\3f\3f\3g\3"+
		"g\3h\3h\3h\3i\3i\3i\3j\3j\3k\3k\3l\3l\3m\3m\3m\3n\3n\3n\3o\3o\3o\3o\3"+
		"p\3p\3p\3q\3q\3q\3r\3r\3r\3s\3s\3s\3t\3t\3t\3u\3u\3u\3v\3v\3v\3w\3w\3"+
		"w\3x\3x\3x\3x\3y\3y\3y\3y\3z\3z\3z\3z\3z\4\u0298\u02a4\2{\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{"+
		"\2}\2\177?\u0081\2\u0083\2\u0085\2\u0087@\u0089A\u008b\2\u008d\2\u008f"+
		"\2\u0091\2\u0093B\u0095\2\u0097C\u0099D\u009bE\u009dF\u009fG\u00a1H\u00a3"+
		"I\u00a5J\u00a7K\u00a9L\u00abM\u00adN\u00afO\u00b1P\u00b3Q\u00b5R\u00b7"+
		"S\u00b9T\u00bbU\u00bdV\u00bfW\u00c1X\u00c3Y\u00c5Z\u00c7[\u00c9\\\u00cb"+
		"]\u00cd^\u00cf_\u00d1`\u00d3a\u00d5b\u00d7c\u00d9d\u00dbe\u00ddf\u00df"+
		"g\u00e1h\u00e3i\u00e5j\u00e7k\u00e9l\u00ebm\u00edn\u00efo\u00f1p\u00f3"+
		"q\3\2\7\4\2\13\f\"\"\5\2C\\aac|\3\2\62;\3\2))\4\2\f\f$$\2\u035b\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u0093\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1"+
		"\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2"+
		"\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3"+
		"\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2"+
		"\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5"+
		"\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2"+
		"\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7"+
		"\3\2\2\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2"+
		"\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9"+
		"\3\2\2\2\2\u00eb\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2"+
		"\2\2\u00f3\3\2\2\2\3\u00f5\3\2\2\2\5\u00f9\3\2\2\2\7\u00ff\3\2\2\2\t\u0105"+
		"\3\2\2\2\13\u010e\3\2\2\2\r\u0113\3\2\2\2\17\u011b\3\2\2\2\21\u011e\3"+
		"\2\2\2\23\u0122\3\2\2\2\25\u012a\3\2\2\2\27\u0134\3\2\2\2\31\u013b\3\2"+
		"\2\2\33\u0142\3\2\2\2\35\u0149\3\2\2\2\37\u014f\3\2\2\2!\u0154\3\2\2\2"+
		"#\u015a\3\2\2\2%\u0162\3\2\2\2\'\u0167\3\2\2\2)\u016b\3\2\2\2+\u0170\3"+
		"\2\2\2-\u0179\3\2\2\2/\u017e\3\2\2\2\61\u0183\3\2\2\2\63\u0189\3\2\2\2"+
		"\65\u018f\3\2\2\2\67\u0197\3\2\2\29\u019a\3\2\2\2;\u01a1\3\2\2\2=\u01a7"+
		"\3\2\2\2?\u01af\3\2\2\2A\u01b3\3\2\2\2C\u01be\3\2\2\2E\u01c5\3\2\2\2G"+
		"\u01d0\3\2\2\2I\u01da\3\2\2\2K\u01df\3\2\2\2M\u01e6\3\2\2\2O\u01eb\3\2"+
		"\2\2Q\u01f3\3\2\2\2S\u01f9\3\2\2\2U\u0200\3\2\2\2W\u020d\3\2\2\2Y\u0213"+
		"\3\2\2\2[\u021a\3\2\2\2]\u0224\3\2\2\2_\u0228\3\2\2\2a\u0231\3\2\2\2c"+
		"\u0239\3\2\2\2e\u023e\3\2\2\2g\u0245\3\2\2\2i\u024d\3\2\2\2k\u0253\3\2"+
		"\2\2m\u0258\3\2\2\2o\u0261\3\2\2\2q\u0267\3\2\2\2s\u026c\3\2\2\2u\u0270"+
		"\3\2\2\2w\u0275\3\2\2\2y\u027b\3\2\2\2{\u0281\3\2\2\2}\u0285\3\2\2\2\177"+
		"\u0287\3\2\2\2\u0081\u028e\3\2\2\2\u0083\u0291\3\2\2\2\u0085\u0294\3\2"+
		"\2\2\u0087\u02a8\3\2\2\2\u0089\u02b2\3\2\2\2\u008b\u02b4\3\2\2\2\u008d"+
		"\u02b9\3\2\2\2\u008f\u02be\3\2\2\2\u0091\u02c4\3\2\2\2\u0093\u02cc\3\2"+
		"\2\2\u0095\u02d2\3\2\2\2\u0097\u02d8\3\2\2\2\u0099\u02e2\3\2\2\2\u009b"+
		"\u02e4\3\2\2\2\u009d\u02e6\3\2\2\2\u009f\u02e8\3\2\2\2\u00a1\u02ea\3\2"+
		"\2\2\u00a3\u02ec\3\2\2\2\u00a5\u02ee\3\2\2\2\u00a7\u02f0\3\2\2\2\u00a9"+
		"\u02f2\3\2\2\2\u00ab\u02f4\3\2\2\2\u00ad\u02f6\3\2\2\2\u00af\u02f8\3\2"+
		"\2\2\u00b1\u02fa\3\2\2\2\u00b3\u02fc\3\2\2\2\u00b5\u02ff\3\2\2\2\u00b7"+
		"\u0302\3\2\2\2\u00b9\u0305\3\2\2\2\u00bb\u0308\3\2\2\2\u00bd\u030a\3\2"+
		"\2\2\u00bf\u030c\3\2\2\2\u00c1\u030e\3\2\2\2\u00c3\u0310\3\2\2\2\u00c5"+
		"\u0313\3\2\2\2\u00c7\u0316\3\2\2\2\u00c9\u0318\3\2\2\2\u00cb\u031a\3\2"+
		"\2\2\u00cd\u031c\3\2\2\2\u00cf\u031e\3\2\2\2\u00d1\u0321\3\2\2\2\u00d3"+
		"\u0324\3\2\2\2\u00d5\u0326\3\2\2\2\u00d7\u0328\3\2\2\2\u00d9\u032a\3\2"+
		"\2\2\u00db\u032d\3\2\2\2\u00dd\u0330\3\2\2\2\u00df\u0334\3\2\2\2\u00e1"+
		"\u0337\3\2\2\2\u00e3\u033a\3\2\2\2\u00e5\u033d\3\2\2\2\u00e7\u0340\3\2"+
		"\2\2\u00e9\u0343\3\2\2\2\u00eb\u0346\3\2\2\2\u00ed\u0349\3\2\2\2\u00ef"+
		"\u034c\3\2\2\2\u00f1\u0350\3\2\2\2\u00f3\u0354\3\2\2\2\u00f5\u00f6\t\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\b\2\2\2\u00f8\4\3\2\2\2\u00f9\u00fa"+
		"\7d\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7c\2\2\u00fd"+
		"\u00fe\7m\2\2\u00fe\6\3\2\2\2\u00ff\u0100\7e\2\2\u0100\u0101\7n\2\2\u0101"+
		"\u0102\7c\2\2\u0102\u0103\7u\2\2\u0103\u0104\7u\2\2\u0104\b\3\2\2\2\u0105"+
		"\u0106\7e\2\2\u0106\u0107\7q\2\2\u0107\u0108\7p\2\2\u0108\u0109\7v\2\2"+
		"\u0109\u010a\7k\2\2\u010a\u010b\7p\2\2\u010b\u010c\7w\2\2\u010c\u010d"+
		"\7g\2\2\u010d\n\3\2\2\2\u010e\u010f\7g\2\2\u010f\u0110\7n\2\2\u0110\u0111"+
		"\7u\2\2\u0111\u0112\7g\2\2\u0112\f\3\2\2\2\u0113\u0114\7g\2\2\u0114\u0115"+
		"\7z\2\2\u0115\u0116\7v\2\2\u0116\u0117\7g\2\2\u0117\u0118\7p\2\2\u0118"+
		"\u0119\7f\2\2\u0119\u011a\7u\2\2\u011a\16\3\2\2\2\u011b\u011c\7k\2\2\u011c"+
		"\u011d\7h\2\2\u011d\20\3\2\2\2\u011e\u011f\7p\2\2\u011f\u0120\7g\2\2\u0120"+
		"\u0121\7y\2\2\u0121\22\3\2\2\2\u0122\u0123\7r\2\2\u0123\u0124\7t\2\2\u0124"+
		"\u0125\7k\2\2\u0125\u0126\7x\2\2\u0126\u0127\7c\2\2\u0127\u0128\7v\2\2"+
		"\u0128\u0129\7g\2\2\u0129\24\3\2\2\2\u012a\u012b\7r\2\2\u012b\u012c\7"+
		"t\2\2\u012c\u012d\7q\2\2\u012d\u012e\7v\2\2\u012e\u012f\7g\2\2\u012f\u0130"+
		"\7e\2\2\u0130\u0131\7v\2\2\u0131\u0132\7g\2\2\u0132\u0133\7f\2\2\u0133"+
		"\26\3\2\2\2\u0134\u0135\7r\2\2\u0135\u0136\7w\2\2\u0136\u0137\7d\2\2\u0137"+
		"\u0138\7n\2\2\u0138\u0139\7k\2\2\u0139\u013a\7e\2\2\u013a\30\3\2\2\2\u013b"+
		"\u013c\7t\2\2\u013c\u013d\7g\2\2\u013d\u013e\7v\2\2\u013e\u013f\7w\2\2"+
		"\u013f\u0140\7t\2\2\u0140\u0141\7p\2\2\u0141\32\3\2\2\2\u0142\u0143\7"+
		"u\2\2\u0143\u0144\7v\2\2\u0144\u0145\7c\2\2\u0145\u0146\7v\2\2\u0146\u0147"+
		"\7k\2\2\u0147\u0148\7e\2\2\u0148\34\3\2\2\2\u0149\u014a\7u\2\2\u014a\u014b"+
		"\7w\2\2\u014b\u014c\7r\2\2\u014c\u014d\7g\2\2\u014d\u014e\7t\2\2\u014e"+
		"\36\3\2\2\2\u014f\u0150\7v\2\2\u0150\u0151\7j\2\2\u0151\u0152\7k\2\2\u0152"+
		"\u0153\7u\2\2\u0153 \3\2\2\2\u0154\u0155\7y\2\2\u0155\u0156\7j\2\2\u0156"+
		"\u0157\7k\2\2\u0157\u0158\7n\2\2\u0158\u0159\7g\2\2\u0159\"\3\2\2\2\u015a"+
		"\u015b\7d\2\2\u015b\u015c\7q\2\2\u015c\u015d\7q\2\2\u015d\u015e\7n\2\2"+
		"\u015e\u015f\7g\2\2\u015f\u0160\7c\2\2\u0160\u0161\7p\2\2\u0161$\3\2\2"+
		"\2\u0162\u0163\7e\2\2\u0163\u0164\7j\2\2\u0164\u0165\7c\2\2\u0165\u0166"+
		"\7t\2\2\u0166&\3\2\2\2\u0167\u0168\7k\2\2\u0168\u0169\7p\2\2\u0169\u016a"+
		"\7v\2\2\u016a(\3\2\2\2\u016b\u016c\7x\2\2\u016c\u016d\7q\2\2\u016d\u016e"+
		"\7k\2\2\u016e\u016f\7f\2\2\u016f*\3\2\2\2\u0170\u0171\7c\2\2\u0171\u0172"+
		"\7d\2\2\u0172\u0173\7u\2\2\u0173\u0174\7v\2\2\u0174\u0175\7t\2\2\u0175"+
		"\u0176\7c\2\2\u0176\u0177\7e\2\2\u0177\u0178\7v\2\2\u0178,\3\2\2\2\u0179"+
		"\u017a\7d\2\2\u017a\u017b\7{\2\2\u017b\u017c\7v\2\2\u017c\u017d\7g\2\2"+
		"\u017d.\3\2\2\2\u017e\u017f\7e\2\2\u017f\u0180\7c\2\2\u0180\u0181\7u\2"+
		"\2\u0181\u0182\7g\2\2\u0182\60\3\2\2\2\u0183\u0184\7e\2\2\u0184\u0185"+
		"\7c\2\2\u0185\u0186\7v\2\2\u0186\u0187\7e\2\2\u0187\u0188\7j\2\2\u0188"+
		"\62\3\2\2\2\u0189\u018a\7e\2\2\u018a\u018b\7q\2\2\u018b\u018c\7p\2\2\u018c"+
		"\u018d\7u\2\2\u018d\u018e\7v\2\2\u018e\64\3\2\2\2\u018f\u0190\7f\2\2\u0190"+
		"\u0191\7g\2\2\u0191\u0192\7h\2\2\u0192\u0193\7c\2\2\u0193\u0194\7w\2\2"+
		"\u0194\u0195\7n\2\2\u0195\u0196\7v\2\2\u0196\66\3\2\2\2\u0197\u0198\7"+
		"f\2\2\u0198\u0199\7q\2\2\u01998\3\2\2\2\u019a\u019b\7f\2\2\u019b\u019c"+
		"\7q\2\2\u019c\u019d\7w\2\2\u019d\u019e\7d\2\2\u019e\u019f\7n\2\2\u019f"+
		"\u01a0\7g\2\2\u01a0:\3\2\2\2\u01a1\u01a2\7h\2\2\u01a2\u01a3\7k\2\2\u01a3"+
		"\u01a4\7p\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7n\2\2\u01a6<\3\2\2\2\u01a7"+
		"\u01a8\7h\2\2\u01a8\u01a9\7k\2\2\u01a9\u01aa\7p\2\2\u01aa\u01ab\7c\2\2"+
		"\u01ab\u01ac\7n\2\2\u01ac\u01ad\7n\2\2\u01ad\u01ae\7{\2\2\u01ae>\3\2\2"+
		"\2\u01af\u01b0\7h\2\2\u01b0\u01b1\7q\2\2\u01b1\u01b2\7t\2\2\u01b2@\3\2"+
		"\2\2\u01b3\u01b4\7k\2\2\u01b4\u01b5\7o\2\2\u01b5\u01b6\7r\2\2\u01b6\u01b7"+
		"\7n\2\2\u01b7\u01b8\7g\2\2\u01b8\u01b9\7o\2\2\u01b9\u01ba\7g\2\2\u01ba"+
		"\u01bb\7p\2\2\u01bb\u01bc\7v\2\2\u01bc\u01bd\7u\2\2\u01bdB\3\2\2\2\u01be"+
		"\u01bf\7k\2\2\u01bf\u01c0\7o\2\2\u01c0\u01c1\7r\2\2\u01c1\u01c2\7q\2\2"+
		"\u01c2\u01c3\7t\2\2\u01c3\u01c4\7v\2\2\u01c4D\3\2\2\2\u01c5\u01c6\7k\2"+
		"\2\u01c6\u01c7\7p\2\2\u01c7\u01c8\7u\2\2\u01c8\u01c9\7v\2\2\u01c9\u01ca"+
		"\7c\2\2\u01ca\u01cb\7p\2\2\u01cb\u01cc\7e\2\2\u01cc\u01cd\7g\2\2\u01cd"+
		"\u01ce\7q\2\2\u01ce\u01cf\7h\2\2\u01cfF\3\2\2\2\u01d0\u01d1\7k\2\2\u01d1"+
		"\u01d2\7p\2\2\u01d2\u01d3\7v\2\2\u01d3\u01d4\7g\2\2\u01d4\u01d5\7t\2\2"+
		"\u01d5\u01d6\7h\2\2\u01d6\u01d7\7c\2\2\u01d7\u01d8\7e\2\2\u01d8\u01d9"+
		"\7g\2\2\u01d9H\3\2\2\2\u01da\u01db\7n\2\2\u01db\u01dc\7q\2\2\u01dc\u01dd"+
		"\7p\2\2\u01dd\u01de\7i\2\2\u01deJ\3\2\2\2\u01df\u01e0\7p\2\2\u01e0\u01e1"+
		"\7c\2\2\u01e1\u01e2\7v\2\2\u01e2\u01e3\7k\2\2\u01e3\u01e4\7x\2\2\u01e4"+
		"\u01e5\7g\2\2\u01e5L\3\2\2\2\u01e6\u01e7\7i\2\2\u01e7\u01e8\7q\2\2\u01e8"+
		"\u01e9\7v\2\2\u01e9\u01ea\7q\2\2\u01eaN\3\2\2\2\u01eb\u01ec\7r\2\2\u01ec"+
		"\u01ed\7c\2\2\u01ed\u01ee\7e\2\2\u01ee\u01ef\7m\2\2\u01ef\u01f0\7c\2\2"+
		"\u01f0\u01f1\7i\2\2\u01f1\u01f2\7g\2\2\u01f2P\3\2\2\2\u01f3\u01f4\7u\2"+
		"\2\u01f4\u01f5\7j\2\2\u01f5\u01f6\7q\2\2\u01f6\u01f7\7t\2\2\u01f7\u01f8"+
		"\7v\2\2\u01f8R\3\2\2\2\u01f9\u01fa\7u\2\2\u01fa\u01fb\7y\2\2\u01fb\u01fc"+
		"\7k\2\2\u01fc\u01fd\7v\2\2\u01fd\u01fe\7e\2\2\u01fe\u01ff\7j\2\2\u01ff"+
		"T\3\2\2\2\u0200\u0201\7u\2\2\u0201\u0202\7{\2\2\u0202\u0203\7p\2\2\u0203"+
		"\u0204\7e\2\2\u0204\u0205\7j\2\2\u0205\u0206\7t\2\2\u0206\u0207\7q\2\2"+
		"\u0207\u0208\7p\2\2\u0208\u0209\7k\2\2\u0209\u020a\7|\2\2\u020a\u020b"+
		"\7g\2\2\u020b\u020c\7f\2\2\u020cV\3\2\2\2\u020d\u020e\7v\2\2\u020e\u020f"+
		"\7j\2\2\u020f\u0210\7t\2\2\u0210\u0211\7q\2\2\u0211\u0212\7y\2\2\u0212"+
		"X\3\2\2\2\u0213\u0214\7v\2\2\u0214\u0215\7j\2\2\u0215\u0216\7t\2\2\u0216"+
		"\u0217\7q\2\2\u0217\u0218\7y\2\2\u0218\u0219\7u\2\2\u0219Z\3\2\2\2\u021a"+
		"\u021b\7v\2\2\u021b\u021c\7t\2\2\u021c\u021d\7c\2\2\u021d\u021e\7p\2\2"+
		"\u021e\u021f\7u\2\2\u021f\u0220\7k\2\2\u0220\u0221\7g\2\2\u0221\u0222"+
		"\7p\2\2\u0222\u0223\7v\2\2\u0223\\\3\2\2\2\u0224\u0225\7v\2\2\u0225\u0226"+
		"\7t\2\2\u0226\u0227\7{\2\2\u0227^\3\2\2\2\u0228\u0229\7x\2\2\u0229\u022a"+
		"\7q\2\2\u022a\u022b\7n\2\2\u022b\u022c\7c\2\2\u022c\u022d\7v\2\2\u022d"+
		"\u022e\7k\2\2\u022e\u022f\7n\2\2\u022f\u0230\7g\2\2\u0230`\3\2\2\2\u0231"+
		"\u0232\7d\2\2\u0232\u0233\7{\2\2\u0233\u0234\7x\2\2\u0234\u0235\7c\2\2"+
		"\u0235\u0236\7n\2\2\u0236\u0237\7w\2\2\u0237\u0238\7g\2\2\u0238b\3\2\2"+
		"\2\u0239\u023a\7e\2\2\u023a\u023b\7c\2\2\u023b\u023c\7u\2\2\u023c\u023d"+
		"\7v\2\2\u023dd\3\2\2\2\u023e\u023f\7h\2\2\u023f\u0240\7w\2\2\u0240\u0241"+
		"\7v\2\2\u0241\u0242\7w\2\2\u0242\u0243\7t\2\2\u0243\u0244\7g\2\2\u0244"+
		"f\3\2\2\2\u0245\u0246\7i\2\2\u0246\u0247\7g\2\2\u0247\u0248\7p\2\2\u0248"+
		"\u0249\7g\2\2\u0249\u024a\7t\2\2\u024a\u024b\7k\2\2\u024b\u024c\7e\2\2"+
		"\u024ch\3\2\2\2\u024d\u024e\7k\2\2\u024e\u024f\7p\2\2\u024f\u0250\7p\2"+
		"\2\u0250\u0251\7g\2\2\u0251\u0252\7t\2\2\u0252j\3\2\2\2\u0253\u0254\7"+
		"p\2\2\u0254\u0255\7q\2\2\u0255\u0256\7p\2\2\u0256\u0257\7g\2\2\u0257l"+
		"\3\2\2\2\u0258\u0259\7q\2\2\u0259\u025a\7r\2\2\u025a\u025b\7g\2\2\u025b"+
		"\u025c\7t\2\2\u025c\u025d\7c\2\2\u025d\u025e\7v\2\2\u025e\u025f\7q\2\2"+
		"\u025f\u0260\7t\2\2\u0260n\3\2\2\2\u0261\u0262\7q\2\2\u0262\u0263\7w\2"+
		"\2\u0263\u0264\7v\2\2\u0264\u0265\7g\2\2\u0265\u0266\7t\2\2\u0266p\3\2"+
		"\2\2\u0267\u0268\7t\2\2\u0268\u0269\7g\2\2\u0269\u026a\7u\2\2\u026a\u026b"+
		"\7v\2\2\u026br\3\2\2\2\u026c\u026d\7x\2\2\u026d\u026e\7c\2\2\u026e\u026f"+
		"\7t\2\2\u026ft\3\2\2\2\u0270\u0271\7v\2\2\u0271\u0272\7t\2\2\u0272\u0273"+
		"\7w\2\2\u0273\u0274\7g\2\2\u0274v\3\2\2\2\u0275\u0276\7h\2\2\u0276\u0277"+
		"\7c\2\2\u0277\u0278\7n\2\2\u0278\u0279\7u\2\2\u0279\u027a\7g\2\2\u027a"+
		"x\3\2\2\2\u027b\u027c\7p\2\2\u027c\u027d\7w\2\2\u027d\u027e\7n\2\2\u027e"+
		"\u027f\7n\2\2\u027fz\3\2\2\2\u0280\u0282\t\3\2\2\u0281\u0280\3\2\2\2\u0282"+
		"|\3\2\2\2\u0283\u0286\5{>\2\u0284\u0286\t\4\2\2\u0285\u0283\3\2\2\2\u0285"+
		"\u0284\3\2\2\2\u0286~\3\2\2\2\u0287\u028b\5{>\2\u0288\u028a\5}?\2\u0289"+
		"\u0288\3\2\2\2\u028a\u028d\3\2\2\2\u028b\u0289\3\2\2\2\u028b\u028c\3\2"+
		"\2\2\u028c\u0080\3\2\2\2\u028d\u028b\3\2\2\2\u028e\u028f\7\61\2\2\u028f"+
		"\u0290\7,\2\2\u0290\u0082\3\2\2\2\u0291\u0292\7,\2\2\u0292\u0293\7\61"+
		"\2\2\u0293\u0084\3\2\2\2\u0294\u0298\5\u0081A\2\u0295\u0297\13\2\2\2\u0296"+
		"\u0295\3\2\2\2\u0297\u029a\3\2\2\2\u0298\u0299\3\2\2\2\u0298\u0296\3\2"+
		"\2\2\u0299\u029b\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u029c\5\u0083B\2\u029c"+
		"\u0086\3\2\2\2\u029d\u02a9\5\u0085C\2\u029e\u029f\7\61\2\2\u029f\u02a0"+
		"\7\61\2\2\u02a0\u02a4\3\2\2\2\u02a1\u02a3\13\2\2\2\u02a2\u02a1\3\2\2\2"+
		"\u02a3\u02a6\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a5\u02a7"+
		"\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7\u02a9\7\f\2\2\u02a8\u029d\3\2\2\2\u02a8"+
		"\u029e\3\2\2\2\u02a9\u0088\3\2\2\2\u02aa\u02b3\7\62\2\2\u02ab\u02af\4"+
		"\63;\2\u02ac\u02ae\4\62;\2\u02ad\u02ac\3\2\2\2\u02ae\u02b1\3\2\2\2\u02af"+
		"\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1\u02af\3\2"+
		"\2\2\u02b2\u02aa\3\2\2\2\u02b2\u02ab\3\2\2\2\u02b3\u008a\3\2\2\2\u02b4"+
		"\u02b5\7)\2\2\u02b5\u02b6\7^\2\2\u02b6\u02b7\7p\2\2\u02b7\u02b8\7)\2\2"+
		"\u02b8\u008c\3\2\2\2\u02b9\u02ba\7)\2\2\u02ba\u02bb\7^\2\2\u02bb\u02bc"+
		"\7v\2\2\u02bc\u02bd\7)\2\2\u02bd\u008e\3\2\2\2\u02be\u02bf\7)\2\2\u02bf"+
		"\u02c0\7^\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\13\2\2\2\u02c2\u02c3\7^"+
		"\2\2\u02c3\u0090\3\2\2\2\u02c4\u02c5\7)\2\2\u02c5\u02c6\n\5\2\2\u02c6"+
		"\u02c7\7)\2\2\u02c7\u0092\3\2\2\2\u02c8\u02cd\5\u008bF\2\u02c9\u02cd\5"+
		"\u008dG\2\u02ca\u02cd\5\u008fH\2\u02cb\u02cd\5\u0091I\2\u02cc\u02c8\3"+
		"\2\2\2\u02cc\u02c9\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cb\3\2\2\2\u02cd"+
		"\u0094\3\2\2\2\u02ce\u02cf\7^\2\2\u02cf\u02d1\7^\2\2\u02d0\u02ce\3\2\2"+
		"\2\u02d1\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d5"+
		"\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02d6\7^\2\2\u02d6\u02d7\7$\2\2\u02d7"+
		"\u0096\3\2\2\2\u02d8\u02dd\7$\2\2\u02d9\u02dc\n\6\2\2\u02da\u02dc\5\u0095"+
		"K\2\u02db\u02d9\3\2\2\2\u02db\u02da\3\2\2\2\u02dc\u02df\3\2\2\2\u02dd"+
		"\u02db\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02e0\3\2\2\2\u02df\u02dd\3\2"+
		"\2\2\u02e0\u02e1\7$\2\2\u02e1\u0098\3\2\2\2\u02e2\u02e3\7*\2\2\u02e3\u009a"+
		"\3\2\2\2\u02e4\u02e5\7+\2\2\u02e5\u009c\3\2\2\2\u02e6\u02e7\7}\2\2\u02e7"+
		"\u009e\3\2\2\2\u02e8\u02e9\7\177\2\2\u02e9\u00a0\3\2\2\2\u02ea\u02eb\7"+
		"]\2\2\u02eb\u00a2\3\2\2\2\u02ec\u02ed\7_\2\2\u02ed\u00a4\3\2\2\2\u02ee"+
		"\u02ef\7=\2\2\u02ef\u00a6\3\2\2\2\u02f0\u02f1\7.\2\2\u02f1\u00a8\3\2\2"+
		"\2\u02f2\u02f3\7\60\2\2\u02f3\u00aa\3\2\2\2\u02f4\u02f5\7?\2\2\u02f5\u00ac"+
		"\3\2\2\2\u02f6\u02f7\7@\2\2\u02f7\u00ae\3\2\2\2\u02f8\u02f9\7>\2\2\u02f9"+
		"\u00b0\3\2\2\2\u02fa\u02fb\7#\2\2\u02fb\u00b2\3\2\2\2\u02fc\u02fd\7?\2"+
		"\2\u02fd\u02fe\7?\2\2\u02fe\u00b4\3\2\2\2\u02ff\u0300\7@\2\2\u0300\u0301"+
		"\7?\2\2\u0301\u00b6\3\2\2\2\u0302\u0303\7>\2\2\u0303\u0304\7?\2\2\u0304"+
		"\u00b8\3\2\2\2\u0305\u0306\7#\2\2\u0306\u0307\7?\2\2\u0307\u00ba\3\2\2"+
		"\2\u0308\u0309\7-\2\2\u0309\u00bc\3\2\2\2\u030a\u030b\7/\2\2\u030b\u00be"+
		"\3\2\2\2\u030c\u030d\7,\2\2\u030d\u00c0\3\2\2\2\u030e\u030f\7\61\2\2\u030f"+
		"\u00c2\3\2\2\2\u0310\u0311\7(\2\2\u0311\u0312\7(\2\2\u0312\u00c4\3\2\2"+
		"\2\u0313\u0314\7~\2\2\u0314\u0315\7~\2\2\u0315\u00c6\3\2\2\2\u0316\u0317"+
		"\7\'\2\2\u0317\u00c8\3\2\2\2\u0318\u0319\7\u0080\2\2\u0319\u00ca\3\2\2"+
		"\2\u031a\u031b\7A\2\2\u031b\u00cc\3\2\2\2\u031c\u031d\7<\2\2\u031d\u00ce"+
		"\3\2\2\2\u031e\u031f\7-\2\2\u031f\u0320\7-\2\2\u0320\u00d0\3\2\2\2\u0321"+
		"\u0322\7/\2\2\u0322\u0323\7/\2\2\u0323\u00d2\3\2\2\2\u0324\u0325\7(\2"+
		"\2\u0325\u00d4\3\2\2\2\u0326\u0327\7~\2\2\u0327\u00d6\3\2\2\2\u0328\u0329"+
		"\7`\2\2\u0329\u00d8\3\2\2\2\u032a\u032b\7>\2\2\u032b\u032c\7>\2\2\u032c"+
		"\u00da\3\2\2\2\u032d\u032e\7@\2\2\u032e\u032f\7@\2\2\u032f\u00dc\3\2\2"+
		"\2\u0330\u0331\7@\2\2\u0331\u0332\7@\2\2\u0332\u0333\7@\2\2\u0333\u00de"+
		"\3\2\2\2\u0334\u0335\7-\2\2\u0335\u0336\7?\2\2\u0336\u00e0\3\2\2\2\u0337"+
		"\u0338\7/\2\2\u0338\u0339\7?\2\2\u0339\u00e2\3\2\2\2\u033a\u033b\7,\2"+
		"\2\u033b\u033c\7?\2\2\u033c\u00e4\3\2\2\2\u033d\u033e\7\61\2\2\u033e\u033f"+
		"\7?\2\2\u033f\u00e6\3\2\2\2\u0340\u0341\7(\2\2\u0341\u0342\7?\2\2\u0342"+
		"\u00e8\3\2\2\2\u0343\u0344\7~\2\2\u0344\u0345\7?\2\2\u0345\u00ea\3\2\2"+
		"\2\u0346\u0347\7`\2\2\u0347\u0348\7?\2\2\u0348\u00ec\3\2\2\2\u0349\u034a"+
		"\7\'\2\2\u034a\u034b\7?\2\2\u034b\u00ee\3\2\2\2\u034c\u034d\7>\2\2\u034d"+
		"\u034e\7>\2\2\u034e\u034f\7?\2\2\u034f\u00f0\3\2\2\2\u0350\u0351\7@\2"+
		"\2\u0351\u0352\7@\2\2\u0352\u0353\7?\2\2\u0353\u00f2\3\2\2\2\u0354\u0355"+
		"\7@\2\2\u0355\u0356\7@\2\2\u0356\u0357\7@\2\2\u0357\u0358\7?\2\2\u0358"+
		"\u00f4\3\2\2\2\17\2\u0281\u0285\u028b\u0298\u02a4\u02a8\u02af\u02b2\u02cc"+
		"\u02d2\u02db\u02dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}