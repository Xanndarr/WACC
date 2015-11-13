// Generated from ./WACCParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WACCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LT=46, FST=23, WHILE=18, BOOL_TYPE=33, MOD=41, GTE=45, CHAR=30, DO=19, 
		SUB=38, NOT=50, ID=26, AND=42, DOUBLEQUOTE=61, ESCAPED_CHAR=31, ORD=52, 
		LTE=47, IF=14, FREE=10, CLOSE_PARENTHESES=56, THEN=15, COMMENTS=2, COMMA=59, 
		DONE=20, IS=7, PRINTLN=13, BEGIN=3, RETURN=11, APOSTROPHE=60, EQ=48, NEWPAIR=22, 
		ADD=37, EXIT=6, PAIR_TYPE=36, OPEN_SQUARE_BRACKET=57, SND=24, CHAR_TYPE=34, 
		NULL=25, ELSE=16, BOOL=29, SEMICOLON=63, INT=27, MINUS=51, INT_TYPE=32, 
		MULT=39, PRINT=12, CHR=53, FI=17, CLOSE_SQUARE_BRACKET=58, SKIP=5, NEQ=49, 
		WS=1, READ=9, STRING_TYPE=35, OR=43, OPEN_PARENTHESES=55, LEN=54, GT=44, 
		ASSIGNMENT=8, CALL=21, DIV=40, END=4, BACKSLASH=62, INT_SIGN=28;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "COMMENTS", "'begin'", "'end'", "'skip'", "'exit'", 
		"'is'", "'='", "'read'", "'free'", "'return'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'call'", 
		"'newpair'", "'fst'", "'snd'", "'null'", "ID", "INT", "INT_SIGN", "BOOL", 
		"CHAR", "ESCAPED_CHAR", "'int'", "'bool'", "'char'", "'string'", "'pair'", 
		"'+'", "SUB", "'*'", "'/'", "'%'", "'&&'", "'||'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'!'", "MINUS", "'ord'", "'chr'", "'len'", "'('", 
		"')'", "'['", "']'", "','", "'''", "'\"'", "'\\'", "';'"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_base_type = 10, RULE_array_type = 11, 
		RULE_pair_type = 12, RULE_pair_elem_type = 13, RULE_expr = 14, RULE_unary_oper = 15, 
		RULE_binary_oper = 16, RULE_array_elem = 17, RULE_int_liter = 18, RULE_bool_liter = 19, 
		RULE_char_liter = 20, RULE_str_liter = 21, RULE_array_liter = 22, RULE_pair_liter = 23;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "base_type", "array_type", "pair_type", 
		"pair_elem_type", "expr", "unary_oper", "binary_oper", "array_elem", "int_liter", 
		"bool_liter", "char_liter", "str_liter", "array_liter", "pair_liter"
	};

	@Override
	public String getGrammarFileName() { return "WACCParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WACCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(WACCParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(WACCParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WACCParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(BEGIN);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49); func();
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(55); stat(0);
			setState(56); match(END);
			setState(57); match(EOF);
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

	public static class FuncContext extends ParserRuleContext {
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IS() { return getToken(WACCParser.IS, 0); }
		public TerminalNode END() { return getToken(WACCParser.END, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); type();
			setState(60); match(ID);
			setState(61); match(OPEN_PARENTHESES);
			setState(63);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << BOOL_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PAIR_TYPE))) != 0)) {
				{
				setState(62); param_list();
				}
			}

			setState(65); match(CLOSE_PARENTHESES);
			setState(66); match(IS);
			setState(67); stat(0);
			setState(68); match(END);
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

	public static class Param_listContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); param();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(71); match(COMMA);
				setState(72); param();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); type();
			setState(79); match(ID);
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

	public static class StatContext extends ParserRuleContext {
		public TerminalNode THEN() { return getToken(WACCParser.THEN, 0); }
		public TerminalNode PRINT() { return getToken(WACCParser.PRINT, 0); }
		public TerminalNode SEMICOLON() { return getToken(WACCParser.SEMICOLON, 0); }
		public TerminalNode FI() { return getToken(WACCParser.FI, 0); }
		public TerminalNode DONE() { return getToken(WACCParser.DONE, 0); }
		public TerminalNode SKIP() { return getToken(WACCParser.SKIP, 0); }
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(WACCParser.ASSIGNMENT, 0); }
		public TerminalNode WHILE() { return getToken(WACCParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(WACCParser.IF, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode DO() { return getToken(WACCParser.DO, 0); }
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(WACCParser.ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode READ() { return getToken(WACCParser.READ, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(WACCParser.RETURN, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode FREE() { return getToken(WACCParser.FREE, 0); }
		public TerminalNode EXIT() { return getToken(WACCParser.EXIT, 0); }
		public TerminalNode BEGIN() { return getToken(WACCParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WACCParser.END, 0); }
		public TerminalNode PRINTLN() { return getToken(WACCParser.PRINTLN, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(82); match(SKIP);
				}
				break;
			case INT_TYPE:
			case BOOL_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
			case PAIR_TYPE:
				{
				setState(83); type();
				setState(84); match(ID);
				setState(85); match(ASSIGNMENT);
				setState(86); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case ID:
				{
				setState(88); assign_lhs();
				setState(89); match(ASSIGNMENT);
				setState(90); assign_rhs();
				}
				break;
			case READ:
				{
				setState(92); match(READ);
				setState(93); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(94); match(FREE);
				setState(95); expr(0);
				}
				break;
			case RETURN:
				{
				setState(96); match(RETURN);
				setState(97); expr(0);
				}
				break;
			case EXIT:
				{
				setState(98); match(EXIT);
				setState(99); expr(0);
				}
				break;
			case PRINT:
				{
				setState(100); match(PRINT);
				setState(101); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(102); match(PRINTLN);
				setState(103); expr(0);
				}
				break;
			case IF:
				{
				setState(104); match(IF);
				setState(105); expr(0);
				setState(106); match(THEN);
				setState(107); stat(0);
				setState(108); match(ELSE);
				setState(109); stat(0);
				setState(110); match(FI);
				}
				break;
			case WHILE:
				{
				setState(112); match(WHILE);
				setState(113); expr(0);
				setState(114); match(DO);
				setState(115); stat(0);
				setState(116); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(118); match(BEGIN);
				setState(119); stat(0);
				setState(120); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(124);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(125); match(SEMICOLON);
					setState(126); stat(2);
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class Assign_lhsContext extends ParserRuleContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssign_lhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_lhs);
		try {
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134); pair_elem();
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

	public static class Assign_rhsContext extends ParserRuleContext {
		public TerminalNode CALL() { return getToken(WACCParser.CALL, 0); }
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEWPAIR() { return getToken(WACCParser.NEWPAIR, 0); }
		public Array_literContext array_liter() {
			return getRuleContext(Array_literContext.class,0);
		}
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssign_rhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign_rhs);
		int _la;
		try {
			setState(154);
			switch (_input.LA(1)) {
			case NULL:
			case ID:
			case INT:
			case INT_SIGN:
			case BOOL:
			case NOT:
			case MINUS:
			case ORD:
			case CHR:
			case LEN:
			case OPEN_PARENTHESES:
			case APOSTROPHE:
			case DOUBLEQUOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); expr(0);
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(138); array_liter();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(139); match(NEWPAIR);
				setState(140); match(OPEN_PARENTHESES);
				setState(141); expr(0);
				setState(142); match(COMMA);
				setState(143); expr(0);
				setState(144); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				enterOuterAlt(_localctx, 4);
				{
				setState(146); pair_elem();
				}
				break;
			case CALL:
				enterOuterAlt(_localctx, 5);
				{
				setState(147); match(CALL);
				setState(148); match(ID);
				setState(149); match(OPEN_PARENTHESES);
				setState(151);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << ID) | (1L << INT) | (1L << INT_SIGN) | (1L << BOOL) | (1L << NOT) | (1L << MINUS) | (1L << ORD) | (1L << CHR) | (1L << LEN) | (1L << OPEN_PARENTHESES) | (1L << APOSTROPHE) | (1L << DOUBLEQUOTE))) != 0)) {
					{
					setState(150); arg_list();
					}
				}

				setState(153); match(CLOSE_PARENTHESES);
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

	public static class Arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); expr(0);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(157); match(COMMA);
				setState(158); expr(0);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Pair_elemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FST() { return getToken(WACCParser.FST, 0); }
		public TerminalNode SND() { return getToken(WACCParser.SND, 0); }
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPair_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pair_elem);
		try {
			setState(168);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(164); match(FST);
				setState(165); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); match(SND);
				setState(167); expr(0);
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

	public static class TypeContext extends ParserRuleContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171); array_type(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172); pair_type();
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

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(WACCParser.INT_TYPE, 0); }
		public TerminalNode CHAR_TYPE() { return getToken(WACCParser.CHAR_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(WACCParser.STRING_TYPE, 0); }
		public TerminalNode BOOL_TYPE() { return getToken(WACCParser.BOOL_TYPE, 0); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBase_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_base_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << BOOL_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WACCParser.OPEN_SQUARE_BRACKET, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WACCParser.CLOSE_SQUARE_BRACKET, 0); }
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		return array_type(0);
	}

	private Array_typeContext array_type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Array_typeContext _localctx = new Array_typeContext(_ctx, _parentState);
		Array_typeContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_array_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			switch (_input.LA(1)) {
			case INT_TYPE:
			case BOOL_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
				{
				setState(178); base_type();
				setState(179); match(OPEN_SQUARE_BRACKET);
				setState(180); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case PAIR_TYPE:
				{
				setState(182); pair_type();
				setState(183); match(OPEN_SQUARE_BRACKET);
				setState(184); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Array_typeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_array_type);
					setState(188);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(189); match(OPEN_SQUARE_BRACKET);
					setState(190); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Pair_typeContext extends ParserRuleContext {
		public List<Pair_elem_typeContext> pair_elem_type() {
			return getRuleContexts(Pair_elem_typeContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public TerminalNode PAIR_TYPE() { return getToken(WACCParser.PAIR_TYPE, 0); }
		public Pair_elem_typeContext pair_elem_type(int i) {
			return getRuleContext(Pair_elem_typeContext.class,i);
		}
		public Pair_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPair_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_typeContext pair_type() throws RecognitionException {
		Pair_typeContext _localctx = new Pair_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); match(PAIR_TYPE);
			setState(197); match(OPEN_PARENTHESES);
			setState(198); pair_elem_type();
			setState(199); match(COMMA);
			setState(200); pair_elem_type();
			setState(201); match(CLOSE_PARENTHESES);
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

	public static class Pair_elem_typeContext extends ParserRuleContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TerminalNode PAIR_TYPE() { return getToken(WACCParser.PAIR_TYPE, 0); }
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPair_elem_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pair_elem_type);
		try {
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); array_type(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205); match(PAIR_TYPE);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public Unary_operContext unary_oper() {
			return getRuleContext(Unary_operContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public Binary_operContext binary_oper() {
			return getRuleContext(Binary_operContext.class,0);
		}
		public Char_literContext char_liter() {
			return getRuleContext(Char_literContext.class,0);
		}
		public Str_literContext str_liter() {
			return getRuleContext(Str_literContext.class,0);
		}
		public Int_literContext int_liter() {
			return getRuleContext(Int_literContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Pair_literContext pair_liter() {
			return getRuleContext(Pair_literContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public Bool_literContext bool_liter() {
			return getRuleContext(Bool_literContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(209); unary_oper();
				setState(210); expr(3);
				}
				break;
			case 2:
				{
				setState(212); int_liter();
				}
				break;
			case 3:
				{
				setState(213); bool_liter();
				}
				break;
			case 4:
				{
				setState(214); char_liter();
				}
				break;
			case 5:
				{
				setState(215); str_liter();
				}
				break;
			case 6:
				{
				setState(216); pair_liter();
				}
				break;
			case 7:
				{
				setState(217); match(ID);
				}
				break;
			case 8:
				{
				setState(218); array_elem();
				}
				break;
			case 9:
				{
				setState(219); match(OPEN_PARENTHESES);
				setState(220); expr(0);
				setState(221); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(225);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(226); binary_oper();
					setState(227); expr(3);
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class Unary_operContext extends ParserRuleContext {
		public TerminalNode LEN() { return getToken(WACCParser.LEN, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(WACCParser.NOT, 0); }
		public TerminalNode CHR() { return getToken(WACCParser.CHR, 0); }
		public TerminalNode ORD() { return getToken(WACCParser.ORD, 0); }
		public Unary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitUnary_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operContext unary_oper() throws RecognitionException {
		Unary_operContext _localctx = new Unary_operContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << ORD) | (1L << CHR) | (1L << LEN))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Binary_operContext extends ParserRuleContext {
		public TerminalNode GTE() { return getToken(WACCParser.GTE, 0); }
		public TerminalNode AND() { return getToken(WACCParser.AND, 0); }
		public TerminalNode OR() { return getToken(WACCParser.OR, 0); }
		public TerminalNode LTE() { return getToken(WACCParser.LTE, 0); }
		public TerminalNode ADD() { return getToken(WACCParser.ADD, 0); }
		public TerminalNode EQ() { return getToken(WACCParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(WACCParser.NEQ, 0); }
		public TerminalNode DIV() { return getToken(WACCParser.DIV, 0); }
		public TerminalNode MULT() { return getToken(WACCParser.MULT, 0); }
		public TerminalNode LT() { return getToken(WACCParser.LT, 0); }
		public TerminalNode GT() { return getToken(WACCParser.GT, 0); }
		public TerminalNode MOD() { return getToken(WACCParser.MOD, 0); }
		public TerminalNode SUB() { return getToken(WACCParser.SUB, 0); }
		public Binary_operContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_oper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinary_oper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operContext binary_oper() throws RecognitionException {
		Binary_operContext _localctx = new Binary_operContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binary_oper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << MOD) | (1L << AND) | (1L << OR) | (1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE) | (1L << EQ) | (1L << NEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Array_elemContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_SQUARE_BRACKET() { return getTokens(WACCParser.OPEN_SQUARE_BRACKET); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET(int i) {
			return getToken(WACCParser.CLOSE_SQUARE_BRACKET, i);
		}
		public TerminalNode OPEN_SQUARE_BRACKET(int i) {
			return getToken(WACCParser.OPEN_SQUARE_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_SQUARE_BRACKET() { return getTokens(WACCParser.CLOSE_SQUARE_BRACKET); }
		public Array_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArray_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_elemContext array_elem() throws RecognitionException {
		Array_elemContext _localctx = new Array_elemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238); match(ID);
			setState(243); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(239); match(OPEN_SQUARE_BRACKET);
					setState(240); expr(0);
					setState(241); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(245); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Int_literContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(WACCParser.INT, 0); }
		public TerminalNode INT_SIGN() { return getToken(WACCParser.INT_SIGN, 0); }
		public Int_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitInt_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literContext int_liter() throws RecognitionException {
		Int_literContext _localctx = new Int_literContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_int_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if (_la==INT_SIGN) {
				{
				setState(247); match(INT_SIGN);
				}
			}

			setState(250); match(INT);
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

	public static class Bool_literContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(WACCParser.BOOL, 0); }
		public Bool_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBool_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literContext bool_liter() throws RecognitionException {
		Bool_literContext _localctx = new Bool_literContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_bool_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); match(BOOL);
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

	public static class Char_literContext extends ParserRuleContext {
		public TerminalNode APOSTROPHE(int i) {
			return getToken(WACCParser.APOSTROPHE, i);
		}
		public TerminalNode CHAR() { return getToken(WACCParser.CHAR, 0); }
		public List<TerminalNode> APOSTROPHE() { return getTokens(WACCParser.APOSTROPHE); }
		public Char_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitChar_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literContext char_liter() throws RecognitionException {
		Char_literContext _localctx = new Char_literContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_char_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(APOSTROPHE);
			setState(255); match(CHAR);
			setState(256); match(APOSTROPHE);
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

	public static class Str_literContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLEQUOTE() { return getTokens(WACCParser.DOUBLEQUOTE); }
		public TerminalNode DOUBLEQUOTE(int i) {
			return getToken(WACCParser.DOUBLEQUOTE, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(WACCParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(WACCParser.CHAR, i);
		}
		public Str_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitStr_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Str_literContext str_liter() throws RecognitionException {
		Str_literContext _localctx = new Str_literContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_str_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); match(DOUBLEQUOTE);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CHAR) {
				{
				{
				setState(259); match(CHAR);
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265); match(DOUBLEQUOTE);
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

	public static class Array_literContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WACCParser.OPEN_SQUARE_BRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WACCParser.CLOSE_SQUARE_BRACKET, 0); }
		public Array_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArray_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literContext array_liter() throws RecognitionException {
		Array_literContext _localctx = new Array_literContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(OPEN_SQUARE_BRACKET);
			setState(276);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << ID) | (1L << INT) | (1L << INT_SIGN) | (1L << BOOL) | (1L << NOT) | (1L << MINUS) | (1L << ORD) | (1L << CHR) | (1L << LEN) | (1L << OPEN_PARENTHESES) | (1L << APOSTROPHE) | (1L << DOUBLEQUOTE))) != 0)) {
				{
				setState(268); expr(0);
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(269); match(COMMA);
					setState(270); expr(0);
					}
					}
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(278); match(CLOSE_SQUARE_BRACKET);
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

	public static class Pair_literContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(WACCParser.NULL, 0); }
		public Pair_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPair_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_literContext pair_liter() throws RecognitionException {
		Pair_literContext _localctx = new Pair_literContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pair_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); match(NULL);
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
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 11: return array_type_sempred((Array_typeContext)_localctx, predIndex);
		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean array_type_sempred(Array_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3A\u011d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3"+
		"B\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6}\n\6\3\6\3\6\3\6\7\6\u0082\n\6\f\6\16"+
		"\6\u0085\13\6\3\7\3\7\3\7\5\7\u008a\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009a\n\b\3\b\5\b\u009d\n\b\3\t\3\t\3\t"+
		"\7\t\u00a2\n\t\f\t\16\t\u00a5\13\t\3\n\3\n\3\n\3\n\5\n\u00ab\n\n\3\13"+
		"\3\13\3\13\5\13\u00b0\n\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00bd\n\r\3\r\3\r\3\r\7\r\u00c2\n\r\f\r\16\r\u00c5\13\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00d1\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e2"+
		"\n\20\3\20\3\20\3\20\3\20\7\20\u00e8\n\20\f\20\16\20\u00eb\13\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\6\23\u00f6\n\23\r\23\16\23\u00f7"+
		"\3\24\5\24\u00fb\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\7\27\u0107\n\27\f\27\16\27\u010a\13\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\7\30\u0112\n\30\f\30\16\30\u0115\13\30\5\30\u0117\n\30\3\30\3\30\3\31"+
		"\3\31\3\31\2\5\n\30\36\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\2\5\3\2\"%\3\2\648\3\2\'\63\u0130\2\62\3\2\2\2\4=\3\2\2\2\6H\3"+
		"\2\2\2\bP\3\2\2\2\n|\3\2\2\2\f\u0089\3\2\2\2\16\u009c\3\2\2\2\20\u009e"+
		"\3\2\2\2\22\u00aa\3\2\2\2\24\u00af\3\2\2\2\26\u00b1\3\2\2\2\30\u00bc\3"+
		"\2\2\2\32\u00c6\3\2\2\2\34\u00d0\3\2\2\2\36\u00e1\3\2\2\2 \u00ec\3\2\2"+
		"\2\"\u00ee\3\2\2\2$\u00f0\3\2\2\2&\u00fa\3\2\2\2(\u00fe\3\2\2\2*\u0100"+
		"\3\2\2\2,\u0104\3\2\2\2.\u010d\3\2\2\2\60\u011a\3\2\2\2\62\66\7\5\2\2"+
		"\63\65\5\4\3\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"+
		"9\3\2\2\28\66\3\2\2\29:\5\n\6\2:;\7\6\2\2;<\7\2\2\3<\3\3\2\2\2=>\5\24"+
		"\13\2>?\7\34\2\2?A\79\2\2@B\5\6\4\2A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7"+
		":\2\2DE\7\t\2\2EF\5\n\6\2FG\7\6\2\2G\5\3\2\2\2HM\5\b\5\2IJ\7=\2\2JL\5"+
		"\b\5\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OM\3\2\2\2PQ"+
		"\5\24\13\2QR\7\34\2\2R\t\3\2\2\2ST\b\6\1\2T}\7\7\2\2UV\5\24\13\2VW\7\34"+
		"\2\2WX\7\n\2\2XY\5\16\b\2Y}\3\2\2\2Z[\5\f\7\2[\\\7\n\2\2\\]\5\16\b\2]"+
		"}\3\2\2\2^_\7\13\2\2_}\5\f\7\2`a\7\f\2\2a}\5\36\20\2bc\7\r\2\2c}\5\36"+
		"\20\2de\7\b\2\2e}\5\36\20\2fg\7\16\2\2g}\5\36\20\2hi\7\17\2\2i}\5\36\20"+
		"\2jk\7\20\2\2kl\5\36\20\2lm\7\21\2\2mn\5\n\6\2no\7\22\2\2op\5\n\6\2pq"+
		"\7\23\2\2q}\3\2\2\2rs\7\24\2\2st\5\36\20\2tu\7\25\2\2uv\5\n\6\2vw\7\26"+
		"\2\2w}\3\2\2\2xy\7\5\2\2yz\5\n\6\2z{\7\6\2\2{}\3\2\2\2|S\3\2\2\2|U\3\2"+
		"\2\2|Z\3\2\2\2|^\3\2\2\2|`\3\2\2\2|b\3\2\2\2|d\3\2\2\2|f\3\2\2\2|h\3\2"+
		"\2\2|j\3\2\2\2|r\3\2\2\2|x\3\2\2\2}\u0083\3\2\2\2~\177\f\3\2\2\177\u0080"+
		"\7A\2\2\u0080\u0082\5\n\6\4\u0081~\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\13\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u008a\7\34\2\2\u0087\u008a\5$\23\2\u0088\u008a\5\22\n\2\u0089\u0086\3"+
		"\2\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\r\3\2\2\2\u008b\u009d"+
		"\5\36\20\2\u008c\u009d\5.\30\2\u008d\u008e\7\30\2\2\u008e\u008f\79\2\2"+
		"\u008f\u0090\5\36\20\2\u0090\u0091\7=\2\2\u0091\u0092\5\36\20\2\u0092"+
		"\u0093\7:\2\2\u0093\u009d\3\2\2\2\u0094\u009d\5\22\n\2\u0095\u0096\7\27"+
		"\2\2\u0096\u0097\7\34\2\2\u0097\u0099\79\2\2\u0098\u009a\5\20\t\2\u0099"+
		"\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\7:"+
		"\2\2\u009c\u008b\3\2\2\2\u009c\u008c\3\2\2\2\u009c\u008d\3\2\2\2\u009c"+
		"\u0094\3\2\2\2\u009c\u0095\3\2\2\2\u009d\17\3\2\2\2\u009e\u00a3\5\36\20"+
		"\2\u009f\u00a0\7=\2\2\u00a0\u00a2\5\36\20\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\21\3\2\2"+
		"\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7\31\2\2\u00a7\u00ab\5\36\20\2\u00a8"+
		"\u00a9\7\32\2\2\u00a9\u00ab\5\36\20\2\u00aa\u00a6\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\23\3\2\2\2\u00ac\u00b0\5\26\f\2\u00ad\u00b0\5\30\r\2\u00ae"+
		"\u00b0\5\32\16\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae\3"+
		"\2\2\2\u00b0\25\3\2\2\2\u00b1\u00b2\t\2\2\2\u00b2\27\3\2\2\2\u00b3\u00b4"+
		"\b\r\1\2\u00b4\u00b5\5\26\f\2\u00b5\u00b6\7;\2\2\u00b6\u00b7\7<\2\2\u00b7"+
		"\u00bd\3\2\2\2\u00b8\u00b9\5\32\16\2\u00b9\u00ba\7;\2\2\u00ba\u00bb\7"+
		"<\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd"+
		"\u00c3\3\2\2\2\u00be\u00bf\f\3\2\2\u00bf\u00c0\7;\2\2\u00c0\u00c2\7<\2"+
		"\2\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\31\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7&\2\2\u00c7"+
		"\u00c8\79\2\2\u00c8\u00c9\5\34\17\2\u00c9\u00ca\7=\2\2\u00ca\u00cb\5\34"+
		"\17\2\u00cb\u00cc\7:\2\2\u00cc\33\3\2\2\2\u00cd\u00d1\5\26\f\2\u00ce\u00d1"+
		"\5\30\r\2\u00cf\u00d1\7&\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\35\3\2\2\2\u00d2\u00d3\b\20\1\2\u00d3\u00d4\5 \21"+
		"\2\u00d4\u00d5\5\36\20\5\u00d5\u00e2\3\2\2\2\u00d6\u00e2\5&\24\2\u00d7"+
		"\u00e2\5(\25\2\u00d8\u00e2\5*\26\2\u00d9\u00e2\5,\27\2\u00da\u00e2\5\60"+
		"\31\2\u00db\u00e2\7\34\2\2\u00dc\u00e2\5$\23\2\u00dd\u00de\79\2\2\u00de"+
		"\u00df\5\36\20\2\u00df\u00e0\7:\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00d2\3"+
		"\2\2\2\u00e1\u00d6\3\2\2\2\u00e1\u00d7\3\2\2\2\u00e1\u00d8\3\2\2\2\u00e1"+
		"\u00d9\3\2\2\2\u00e1\u00da\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1\u00dc\3\2"+
		"\2\2\u00e1\u00dd\3\2\2\2\u00e2\u00e9\3\2\2\2\u00e3\u00e4\f\4\2\2\u00e4"+
		"\u00e5\5\"\22\2\u00e5\u00e6\5\36\20\5\u00e6\u00e8\3\2\2\2\u00e7\u00e3"+
		"\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\37\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\t\3\2\2\u00ed!\3\2\2\2\u00ee"+
		"\u00ef\t\4\2\2\u00ef#\3\2\2\2\u00f0\u00f5\7\34\2\2\u00f1\u00f2\7;\2\2"+
		"\u00f2\u00f3\5\36\20\2\u00f3\u00f4\7<\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f1"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"%\3\2\2\2\u00f9\u00fb\7\36\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2"+
		"\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\35\2\2\u00fd\'\3\2\2\2\u00fe\u00ff"+
		"\7\37\2\2\u00ff)\3\2\2\2\u0100\u0101\7>\2\2\u0101\u0102\7 \2\2\u0102\u0103"+
		"\7>\2\2\u0103+\3\2\2\2\u0104\u0108\7?\2\2\u0105\u0107\7 \2\2\u0106\u0105"+
		"\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7?\2\2\u010c-\3\2\2\2\u010d"+
		"\u0116\7;\2\2\u010e\u0113\5\36\20\2\u010f\u0110\7=\2\2\u0110\u0112\5\36"+
		"\20\2\u0111\u010f\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u010e\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7<\2\2\u0119"+
		"/\3\2\2\2\u011a\u011b\7\33\2\2\u011b\61\3\2\2\2\27\66AM|\u0083\u0089\u0099"+
		"\u009c\u00a3\u00aa\u00af\u00bc\u00c3\u00d0\u00e1\u00e9\u00f7\u00fa\u0108"+
		"\u0113\u0116";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}