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
		LT=28, FST=51, WHILE=44, BOOL_TYPE=10, MOD=23, GTE=27, CHAR=5, DO=45, 
		SUB=20, NOT=14, AND=24, ID=1, DOUBLEQUOTE=60, ESCAPED_CHAR=6, ORD=16, 
		LTE=29, IF=40, FREE=35, CLOSE_PARENTHESES=55, EOL=7, THEN=41, COMMA=58, 
		IS=53, DONE=46, PRINTLN=39, BEGIN=47, RETURN=36, APOSTROPHE=59, EQ=30, 
		NEWPAIR=50, ADD=19, EXIT=37, PAIR_TYPE=13, OPEN_SQUARE_BRACKET=56, SND=52, 
		CHAR_TYPE=11, NULL=64, ELSE=42, BOOL=4, HASH=63, SEMICOLON=62, INT=2, 
		MULT=21, MINUS=15, INT_TYPE=9, PRINT=38, CHR=17, FI=43, CLOSE_SQUARE_BRACKET=57, 
		SKIP=32, WS=8, NEQ=31, READ=34, STRING_TYPE=12, OR=25, OPEN_PARENTHESES=54, 
		LEN=18, GT=26, ASSIGNMENT=33, CALL=49, DIV=22, END=48, BACKSLASH=61, INT_SIGN=3;
	public static final String[] tokenNames = {
		"<INVALID>", "ID", "INT", "INT_SIGN", "BOOL", "CHAR", "ESCAPED_CHAR", 
		"EOL", "WS", "'int'", "'bool'", "'char'", "'string'", "'pair'", "'!'", 
		"MINUS", "'ord'", "'chr'", "'len'", "'+'", "SUB", "'*'", "'/'", "'%'", 
		"'&&'", "'||'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'skip'", 
		"'='", "'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", 
		"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'begin'", 
		"'end'", "'call'", "'newpair'", "'fst'", "'snd'", "'is'", "'('", "')'", 
		"'['", "']'", "','", "'''", "'\"'", "'\\'", "';'", "'#'", "'null'"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_base_type = 10, RULE_array_type = 11, 
		RULE_pair_type = 12, RULE_pair_elem_type = 13, RULE_expr = 14, RULE_unary_oper = 15, 
		RULE_binary_oper = 16, RULE_array_elem = 17, RULE_array_liter = 18, RULE_int_liter = 19, 
		RULE_char_liter = 20, RULE_string_liter = 21, RULE_bool_liter = 22, RULE_pair_liter = 23, 
		RULE_comment = 24;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "base_type", "array_type", "pair_type", 
		"pair_elem_type", "expr", "unary_oper", "binary_oper", "array_elem", "array_liter", 
		"int_liter", "char_liter", "string_liter", "bool_liter", "pair_liter", 
		"comment"
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
			setState(50); match(BEGIN);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51); func();
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(57); stat(0);
			setState(58); match(END);
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
			setState(60); type();
			setState(61); match(ID);
			setState(62); match(OPEN_PARENTHESES);
			setState(64);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_TYPE) | (1L << BOOL_TYPE) | (1L << CHAR_TYPE) | (1L << STRING_TYPE) | (1L << PAIR_TYPE))) != 0)) {
				{
				setState(63); param_list();
				}
			}

			setState(66); match(CLOSE_PARENTHESES);
			setState(67); match(IS);
			setState(68); stat(0);
			setState(69); match(END);
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
			setState(71); param();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(72); match(COMMA);
				setState(73); param();
				}
				}
				setState(78);
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
			setState(79); type();
			setState(80); match(ID);
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
		public TerminalNode IF(int i) {
			return getToken(WACCParser.IF, i);
		}
		public TerminalNode DONE() { return getToken(WACCParser.DONE, 0); }
		public TerminalNode SKIP() { return getToken(WACCParser.SKIP, 0); }
		public TerminalNode ID() { return getToken(WACCParser.ID, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(WACCParser.ASSIGNMENT, 0); }
		public TerminalNode WHILE() { return getToken(WACCParser.WHILE, 0); }
		public List<TerminalNode> IF() { return getTokens(WACCParser.IF); }
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
			setState(123);
			switch (_input.LA(1)) {
			case SKIP:
				{
				setState(83); match(SKIP);
				}
				break;
			case INT_TYPE:
			case BOOL_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
			case PAIR_TYPE:
				{
				setState(84); type();
				setState(85); match(ID);
				setState(86); match(ASSIGNMENT);
				setState(87); assign_rhs();
				}
				break;
			case ID:
			case FST:
			case SND:
				{
				setState(89); assign_lhs();
				setState(90); match(ASSIGNMENT);
				setState(91); assign_rhs();
				}
				break;
			case READ:
				{
				setState(93); match(READ);
				setState(94); assign_lhs();
				}
				break;
			case FREE:
				{
				setState(95); match(FREE);
				setState(96); expr(0);
				}
				break;
			case RETURN:
				{
				setState(97); match(RETURN);
				setState(98); expr(0);
				}
				break;
			case EXIT:
				{
				setState(99); match(EXIT);
				setState(100); expr(0);
				}
				break;
			case PRINT:
				{
				setState(101); match(PRINT);
				setState(102); expr(0);
				}
				break;
			case PRINTLN:
				{
				setState(103); match(PRINTLN);
				setState(104); expr(0);
				}
				break;
			case IF:
				{
				setState(105); match(IF);
				setState(106); expr(0);
				setState(107); match(THEN);
				setState(108); stat(0);
				setState(109); match(ELSE);
				setState(110); stat(0);
				setState(111); match(IF);
				}
				break;
			case WHILE:
				{
				setState(113); match(WHILE);
				setState(114); expr(0);
				setState(115); match(DO);
				setState(116); stat(0);
				setState(117); match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(119); match(BEGIN);
				setState(120); stat(0);
				setState(121); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
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
					setState(125);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(126); match(SEMICOLON);
					setState(127); stat(2);
					}
					} 
				}
				setState(132);
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
			setState(136);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135); pair_elem();
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
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
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
			setState(155);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138); expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140); match(NEWPAIR);
				setState(141); match(OPEN_PARENTHESES);
				setState(142); expr(0);
				setState(143); match(COMMA);
				setState(144); expr(0);
				setState(145); match(CLOSE_PARENTHESES);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(147); pair_elem();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(148); match(CALL);
				setState(149); match(ID);
				setState(150); match(OPEN_PARENTHESES);
				setState(152);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (ID - 1)) | (1L << (INT - 1)) | (1L << (INT_SIGN - 1)) | (1L << (BOOL - 1)) | (1L << (NOT - 1)) | (1L << (MINUS - 1)) | (1L << (ORD - 1)) | (1L << (CHR - 1)) | (1L << (LEN - 1)) | (1L << (OPEN_PARENTHESES - 1)) | (1L << (APOSTROPHE - 1)) | (1L << (DOUBLEQUOTE - 1)) | (1L << (NULL - 1)))) != 0)) {
					{
					setState(151); arg_list();
					}
				}

				setState(154); match(CLOSE_PARENTHESES);
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
			setState(157); expr(0);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(158); match(COMMA);
				setState(159); expr(0);
				}
				}
				setState(164);
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
			setState(169);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(165); match(FST);
				setState(166); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(167); match(SND);
				setState(168); expr(0);
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
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172); pair_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173); array_type(0);
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
			setState(176);
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
			setState(187);
			switch (_input.LA(1)) {
			case INT_TYPE:
			case BOOL_TYPE:
			case CHAR_TYPE:
			case STRING_TYPE:
				{
				setState(179); base_type();
				setState(180); match(OPEN_SQUARE_BRACKET);
				setState(181); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case PAIR_TYPE:
				{
				setState(183); pair_type();
				setState(184); match(OPEN_SQUARE_BRACKET);
				setState(185); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
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
					setState(189);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(190); match(OPEN_SQUARE_BRACKET);
					setState(191); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(196);
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
			setState(197); match(PAIR_TYPE);
			setState(198); match(OPEN_PARENTHESES);
			setState(199); pair_elem_type();
			setState(200); match(COMMA);
			setState(201); pair_elem_type();
			setState(202); match(CLOSE_PARENTHESES);
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
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); array_type(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206); match(PAIR_TYPE);
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
		public String_literContext string_liter() {
			return getRuleContext(String_literContext.class,0);
		}
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
			setState(224);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(210); unary_oper();
				setState(211); expr(3);
				}
				break;
			case 2:
				{
				setState(213); int_liter();
				}
				break;
			case 3:
				{
				setState(214); bool_liter();
				}
				break;
			case 4:
				{
				setState(215); char_liter();
				}
				break;
			case 5:
				{
				setState(216); string_liter();
				}
				break;
			case 6:
				{
				setState(217); pair_liter();
				}
				break;
			case 7:
				{
				setState(218); match(ID);
				}
				break;
			case 8:
				{
				setState(219); array_elem();
				}
				break;
			case 9:
				{
				setState(220); match(OPEN_PARENTHESES);
				setState(221); expr(0);
				setState(222); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(232);
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
					setState(226);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(227); binary_oper();
					setState(228); expr(3);
					}
					} 
				}
				setState(234);
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
			setState(235);
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
			setState(237);
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
			setState(239); match(ID);
			setState(244); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(240); match(OPEN_SQUARE_BRACKET);
					setState(241); expr(0);
					setState(242); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(246); 
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
		enterRule(_localctx, 36, RULE_array_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248); match(OPEN_SQUARE_BRACKET);
			setState(257);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (ID - 1)) | (1L << (INT - 1)) | (1L << (INT_SIGN - 1)) | (1L << (BOOL - 1)) | (1L << (NOT - 1)) | (1L << (MINUS - 1)) | (1L << (ORD - 1)) | (1L << (CHR - 1)) | (1L << (LEN - 1)) | (1L << (OPEN_PARENTHESES - 1)) | (1L << (APOSTROPHE - 1)) | (1L << (DOUBLEQUOTE - 1)) | (1L << (NULL - 1)))) != 0)) {
				{
				setState(249); expr(0);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(250); match(COMMA);
					setState(251); expr(0);
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(259); match(CLOSE_SQUARE_BRACKET);
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
		enterRule(_localctx, 38, RULE_int_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if (_la==INT_SIGN) {
				{
				setState(261); match(INT_SIGN);
				}
			}

			setState(264); match(INT);
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
			setState(266); match(APOSTROPHE);
			setState(267); match(CHAR);
			setState(268); match(APOSTROPHE);
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

	public static class String_literContext extends ParserRuleContext {
		public List<TerminalNode> DOUBLEQUOTE() { return getTokens(WACCParser.DOUBLEQUOTE); }
		public TerminalNode DOUBLEQUOTE(int i) {
			return getToken(WACCParser.DOUBLEQUOTE, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(WACCParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(WACCParser.CHAR, i);
		}
		public String_literContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitString_liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_literContext string_liter() throws RecognitionException {
		String_literContext _localctx = new String_literContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_string_liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(DOUBLEQUOTE);
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CHAR) {
				{
				{
				setState(271); match(CHAR);
				}
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(277); match(DOUBLEQUOTE);
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
		enterRule(_localctx, 44, RULE_bool_liter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); match(BOOL);
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
			setState(281); match(NULL);
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

	public static class CommentContext extends ParserRuleContext {
		public List<TerminalNode> EOL() { return getTokens(WACCParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(WACCParser.EOL, i);
		}
		public TerminalNode HASH() { return getToken(WACCParser.HASH, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(HASH);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (ID - 1)) | (1L << (INT - 1)) | (1L << (INT_SIGN - 1)) | (1L << (BOOL - 1)) | (1L << (CHAR - 1)) | (1L << (ESCAPED_CHAR - 1)) | (1L << (WS - 1)) | (1L << (INT_TYPE - 1)) | (1L << (BOOL_TYPE - 1)) | (1L << (CHAR_TYPE - 1)) | (1L << (STRING_TYPE - 1)) | (1L << (PAIR_TYPE - 1)) | (1L << (NOT - 1)) | (1L << (MINUS - 1)) | (1L << (ORD - 1)) | (1L << (CHR - 1)) | (1L << (LEN - 1)) | (1L << (ADD - 1)) | (1L << (SUB - 1)) | (1L << (MULT - 1)) | (1L << (DIV - 1)) | (1L << (MOD - 1)) | (1L << (AND - 1)) | (1L << (OR - 1)) | (1L << (GT - 1)) | (1L << (GTE - 1)) | (1L << (LT - 1)) | (1L << (LTE - 1)) | (1L << (EQ - 1)) | (1L << (NEQ - 1)) | (1L << (SKIP - 1)) | (1L << (ASSIGNMENT - 1)) | (1L << (READ - 1)) | (1L << (FREE - 1)) | (1L << (RETURN - 1)) | (1L << (EXIT - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (IF - 1)) | (1L << (THEN - 1)) | (1L << (ELSE - 1)) | (1L << (FI - 1)) | (1L << (WHILE - 1)) | (1L << (DO - 1)) | (1L << (DONE - 1)) | (1L << (BEGIN - 1)) | (1L << (END - 1)) | (1L << (CALL - 1)) | (1L << (NEWPAIR - 1)) | (1L << (FST - 1)) | (1L << (SND - 1)) | (1L << (IS - 1)) | (1L << (OPEN_PARENTHESES - 1)) | (1L << (CLOSE_PARENTHESES - 1)) | (1L << (OPEN_SQUARE_BRACKET - 1)) | (1L << (CLOSE_SQUARE_BRACKET - 1)) | (1L << (COMMA - 1)) | (1L << (APOSTROPHE - 1)) | (1L << (DOUBLEQUOTE - 1)) | (1L << (BACKSLASH - 1)) | (1L << (SEMICOLON - 1)) | (1L << (HASH - 1)) | (1L << (NULL - 1)))) != 0)) {
				{
				{
				setState(284);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==EOL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(290); match(EOL);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3B\u0127\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\5\3C\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6~\n\6\3\6\3\6\3\6\7\6\u0083\n\6"+
		"\f\6\16\6\u0086\13\6\3\7\3\7\3\7\5\7\u008b\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009b\n\b\3\b\5\b\u009e\n\b\3\t\3"+
		"\t\3\t\7\t\u00a3\n\t\f\t\16\t\u00a6\13\t\3\n\3\n\3\n\3\n\5\n\u00ac\n\n"+
		"\3\13\3\13\3\13\5\13\u00b1\n\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u00be\n\r\3\r\3\r\3\r\7\r\u00c3\n\r\f\r\16\r\u00c6\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00d2\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00e3\n\20\3\20\3\20\3\20\3\20\7\20\u00e9\n\20\f\20\16\20\u00ec\13\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\6\23\u00f7\n\23\r\23\16"+
		"\23\u00f8\3\24\3\24\3\24\3\24\7\24\u00ff\n\24\f\24\16\24\u0102\13\24\5"+
		"\24\u0104\n\24\3\24\3\24\3\25\5\25\u0109\n\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\7\27\u0113\n\27\f\27\16\27\u0116\13\27\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\7\32\u0120\n\32\f\32\16\32\u0123\13\32\3\32"+
		"\3\32\3\32\2\5\n\30\36\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\2\6\3\2\13\16\3\2\20\24\3\2\25!\3\2\t\t\u013a\2\64\3\2\2\2"+
		"\4>\3\2\2\2\6I\3\2\2\2\bQ\3\2\2\2\n}\3\2\2\2\f\u008a\3\2\2\2\16\u009d"+
		"\3\2\2\2\20\u009f\3\2\2\2\22\u00ab\3\2\2\2\24\u00b0\3\2\2\2\26\u00b2\3"+
		"\2\2\2\30\u00bd\3\2\2\2\32\u00c7\3\2\2\2\34\u00d1\3\2\2\2\36\u00e2\3\2"+
		"\2\2 \u00ed\3\2\2\2\"\u00ef\3\2\2\2$\u00f1\3\2\2\2&\u00fa\3\2\2\2(\u0108"+
		"\3\2\2\2*\u010c\3\2\2\2,\u0110\3\2\2\2.\u0119\3\2\2\2\60\u011b\3\2\2\2"+
		"\62\u011d\3\2\2\2\648\7\61\2\2\65\67\5\4\3\2\66\65\3\2\2\2\67:\3\2\2\2"+
		"8\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\5\n\6\2<=\7\62\2\2=\3\3\2"+
		"\2\2>?\5\24\13\2?@\7\3\2\2@B\78\2\2AC\5\6\4\2BA\3\2\2\2BC\3\2\2\2CD\3"+
		"\2\2\2DE\79\2\2EF\7\67\2\2FG\5\n\6\2GH\7\62\2\2H\5\3\2\2\2IN\5\b\5\2J"+
		"K\7<\2\2KM\5\b\5\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\7\3\2\2\2"+
		"PN\3\2\2\2QR\5\24\13\2RS\7\3\2\2S\t\3\2\2\2TU\b\6\1\2U~\7\"\2\2VW\5\24"+
		"\13\2WX\7\3\2\2XY\7#\2\2YZ\5\16\b\2Z~\3\2\2\2[\\\5\f\7\2\\]\7#\2\2]^\5"+
		"\16\b\2^~\3\2\2\2_`\7$\2\2`~\5\f\7\2ab\7%\2\2b~\5\36\20\2cd\7&\2\2d~\5"+
		"\36\20\2ef\7\'\2\2f~\5\36\20\2gh\7(\2\2h~\5\36\20\2ij\7)\2\2j~\5\36\20"+
		"\2kl\7*\2\2lm\5\36\20\2mn\7+\2\2no\5\n\6\2op\7,\2\2pq\5\n\6\2qr\7*\2\2"+
		"r~\3\2\2\2st\7.\2\2tu\5\36\20\2uv\7/\2\2vw\5\n\6\2wx\7\60\2\2x~\3\2\2"+
		"\2yz\7\61\2\2z{\5\n\6\2{|\7\62\2\2|~\3\2\2\2}T\3\2\2\2}V\3\2\2\2}[\3\2"+
		"\2\2}_\3\2\2\2}a\3\2\2\2}c\3\2\2\2}e\3\2\2\2}g\3\2\2\2}i\3\2\2\2}k\3\2"+
		"\2\2}s\3\2\2\2}y\3\2\2\2~\u0084\3\2\2\2\177\u0080\f\3\2\2\u0080\u0081"+
		"\7@\2\2\u0081\u0083\5\n\6\4\u0082\177\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\13\3\2\2\2\u0086\u0084\3\2\2"+
		"\2\u0087\u008b\7\3\2\2\u0088\u008b\5$\23\2\u0089\u008b\5\22\n\2\u008a"+
		"\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\r\3\2\2\2"+
		"\u008c\u009e\5\36\20\2\u008d\u009e\5$\23\2\u008e\u008f\7\64\2\2\u008f"+
		"\u0090\78\2\2\u0090\u0091\5\36\20\2\u0091\u0092\7<\2\2\u0092\u0093\5\36"+
		"\20\2\u0093\u0094\79\2\2\u0094\u009e\3\2\2\2\u0095\u009e\5\22\n\2\u0096"+
		"\u0097\7\63\2\2\u0097\u0098\7\3\2\2\u0098\u009a\78\2\2\u0099\u009b\5\20"+
		"\t\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009e\79\2\2\u009d\u008c\3\2\2\2\u009d\u008d\3\2\2\2\u009d\u008e\3\2"+
		"\2\2\u009d\u0095\3\2\2\2\u009d\u0096\3\2\2\2\u009e\17\3\2\2\2\u009f\u00a4"+
		"\5\36\20\2\u00a0\u00a1\7<\2\2\u00a1\u00a3\5\36\20\2\u00a2\u00a0\3\2\2"+
		"\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\21"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\65\2\2\u00a8\u00ac\5\36\20"+
		"\2\u00a9\u00aa\7\66\2\2\u00aa\u00ac\5\36\20\2\u00ab\u00a7\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\23\3\2\2\2\u00ad\u00b1\5\26\f\2\u00ae\u00b1\5\32"+
		"\16\2\u00af\u00b1\5\30\r\2\u00b0\u00ad\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00af\3\2\2\2\u00b1\25\3\2\2\2\u00b2\u00b3\t\2\2\2\u00b3\27\3\2\2\2\u00b4"+
		"\u00b5\b\r\1\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7\7:\2\2\u00b7\u00b8\7;"+
		"\2\2\u00b8\u00be\3\2\2\2\u00b9\u00ba\5\32\16\2\u00ba\u00bb\7:\2\2\u00bb"+
		"\u00bc\7;\2\2\u00bc\u00be\3\2\2\2\u00bd\u00b4\3\2\2\2\u00bd\u00b9\3\2"+
		"\2\2\u00be\u00c4\3\2\2\2\u00bf\u00c0\f\3\2\2\u00c0\u00c1\7:\2\2\u00c1"+
		"\u00c3\7;\2\2\u00c2\u00bf\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c4\u00c5\3\2\2\2\u00c5\31\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8"+
		"\7\17\2\2\u00c8\u00c9\78\2\2\u00c9\u00ca\5\34\17\2\u00ca\u00cb\7<\2\2"+
		"\u00cb\u00cc\5\34\17\2\u00cc\u00cd\79\2\2\u00cd\33\3\2\2\2\u00ce\u00d2"+
		"\5\26\f\2\u00cf\u00d2\5\30\r\2\u00d0\u00d2\7\17\2\2\u00d1\u00ce\3\2\2"+
		"\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\35\3\2\2\2\u00d3\u00d4"+
		"\b\20\1\2\u00d4\u00d5\5 \21\2\u00d5\u00d6\5\36\20\5\u00d6\u00e3\3\2\2"+
		"\2\u00d7\u00e3\5(\25\2\u00d8\u00e3\5.\30\2\u00d9\u00e3\5*\26\2\u00da\u00e3"+
		"\5,\27\2\u00db\u00e3\5\60\31\2\u00dc\u00e3\7\3\2\2\u00dd\u00e3\5$\23\2"+
		"\u00de\u00df\78\2\2\u00df\u00e0\5\36\20\2\u00e0\u00e1\79\2\2\u00e1\u00e3"+
		"\3\2\2\2\u00e2\u00d3\3\2\2\2\u00e2\u00d7\3\2\2\2\u00e2\u00d8\3\2\2\2\u00e2"+
		"\u00d9\3\2\2\2\u00e2\u00da\3\2\2\2\u00e2\u00db\3\2\2\2\u00e2\u00dc\3\2"+
		"\2\2\u00e2\u00dd\3\2\2\2\u00e2\u00de\3\2\2\2\u00e3\u00ea\3\2\2\2\u00e4"+
		"\u00e5\f\4\2\2\u00e5\u00e6\5\"\22\2\u00e6\u00e7\5\36\20\5\u00e7\u00e9"+
		"\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\37\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\t\3\2"+
		"\2\u00ee!\3\2\2\2\u00ef\u00f0\t\4\2\2\u00f0#\3\2\2\2\u00f1\u00f6\7\3\2"+
		"\2\u00f2\u00f3\7:\2\2\u00f3\u00f4\5\36\20\2\u00f4\u00f5\7;\2\2\u00f5\u00f7"+
		"\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9%\3\2\2\2\u00fa\u0103\7:\2\2\u00fb\u0100\5\36\20\2"+
		"\u00fc\u00fd\7<\2\2\u00fd\u00ff\5\36\20\2\u00fe\u00fc\3\2\2\2\u00ff\u0102"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u00fb\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0106\7;\2\2\u0106\'\3\2\2\2\u0107\u0109\7\5\2\2\u0108\u0107"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7\4\2\2\u010b"+
		")\3\2\2\2\u010c\u010d\7=\2\2\u010d\u010e\7\7\2\2\u010e\u010f\7=\2\2\u010f"+
		"+\3\2\2\2\u0110\u0114\7>\2\2\u0111\u0113\7\7\2\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0117\u0118\7>\2\2\u0118-\3\2\2\2\u0119\u011a"+
		"\7\6\2\2\u011a/\3\2\2\2\u011b\u011c\7B\2\2\u011c\61\3\2\2\2\u011d\u0121"+
		"\7A\2\2\u011e\u0120\n\5\2\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0124\u0125\7\t\2\2\u0125\63\3\2\2\2\308BN}\u0084\u008a\u009a\u009d"+
		"\u00a4\u00ab\u00b0\u00bd\u00c4\u00d1\u00e2\u00ea\u00f8\u0100\u0103\u0108"+
		"\u0114\u0121";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}